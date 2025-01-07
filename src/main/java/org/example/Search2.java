/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.*;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=Search</c>
 */
public class Search2 {
    private static final Logger LOGGER = LogManager.getLogger(Search2.class);

    private static OpenSearchClient client;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        client = SampleClient.create();
        scroll();

    }
    private static final int MAX_ROWS_PER_SHEET = 100000;

    public static void queryAll() throws IOException {
        SearchRequest searchRequest = SearchRequest.of(s -> s
                .index("srp_wide_table")  // 指定索引
                .query(q -> q
                        .matchAll(ma -> ma)  // 使用 match_all 查询所有文档
                ).from(0)
        );
        // 执行搜索请求
        SearchResponse<Map> searchResponse = client.search(searchRequest, Map.class);
        System.out.println(searchResponse);

    }

    public static void queryByDsl() throws IOException {
        SearchRequest searchRequest = SearchRequest.of(s -> s
                .index("srp_wide_table")  // 指定索引
                .query(q -> q
                        .matchAll(ma -> ma)  // 使用 match_all 查询所有文档
                ).from(0)
        );
        // 执行搜索请求
        SearchResponse<Map> searchResponse = client.search(searchRequest, Map.class);
        System.out.println(searchResponse);

    }
    public static void scroll() throws IOException {
        HashMap<String, Integer> sizeMap = new HashMap<>();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("txt.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 设置列宽自适应策略
        WriteCellStyle contentCellStyle = new WriteCellStyle();
        // 可以设置其他样式如背景色、字体等
        WriteFont contentFont = new WriteFont();
        contentCellStyle.setWriteFont(contentFont);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(contentCellStyle, contentCellStyle);
        List<SelectedTable> selectedTableList = getSelectedTable();

        ExcelWriter writer = EasyExcel.write(fileOutputStream).excelType(ExcelTypeEnum.CSV).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .registerWriteHandler(horizontalCellStyleStrategy).build();

        AtomicInteger atomicInt = new AtomicInteger(0);
        // 初始 SearchRequest，使用 match_all 查询，且指定 scroll 参数
        SearchRequest searchRequest = SearchRequest.of(s -> s
                .index("srp_wide_table")  // 查询的索引
                .scroll(scrollTime -> scrollTime.time("5m"))  // 设置 scroll 的有效期
                .query(q -> q.matchAll(ma -> ma))  // 查询所有数据
                .size(100)  // 每次返回 100 条数据（可以根据需要调整）
        );

        // 执行查询，获取第一个批次的数据
        SearchResponse<SrpWideTableDeSerial> searchResponse = client.search(searchRequest, SrpWideTableDeSerial.class);

        // 获取返回的 scroll_id，用于后续查询
        String scrollId = searchResponse.scrollId();

        ArrayList<SrpWideTableDeSerial> results = new ArrayList<>();

        // 处理第一批返回的数据
        searchResponse.hits().hits().forEach(hit -> {
            // 这里处理每条文档数据
            atomicInt.getAndIncrement();
            results.add(hit.source());
        });

        // 继续查询剩余的数据
        while (true) {

            ArrayList<SrpWideTableDeSerial> innerResult = new ArrayList<>();
            if(!results.isEmpty()){
                innerResult.addAll(results);
                results.clear();
            }
            ScrollRequest origin = new ScrollRequest.Builder().scroll(scrollTime -> scrollTime.time("5m")).scrollId(scrollId).build();


            // 执行滚动查询
            SearchResponse<SrpWideTableDeSerial> scrollResponse = client.scroll(origin, SrpWideTableDeSerial.class);

            // 获取新的 scroll_id
            scrollId = scrollResponse.scrollId();

            // 如果没有数据了，退出循环
            if (scrollResponse.hits().hits().isEmpty()) {
                break;
            }

            // 处理返回的文档
            scrollResponse.hits().hits().forEach(hit -> {
                atomicInt.getAndIncrement();
                innerResult.add(hit.source());
            });
            testExport(writer,innerResult,selectedTableList,sizeMap);
        }

        System.out.println("数量:"+atomicInt);

        // 查询结束后，清理 scroll
        clearScroll(client, scrollId);

    }

    // 清理 scroll 的方法
    private static  void clearScroll(OpenSearchClient client, String scrollId) {
        try {
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest.Builder()
                    .scrollId(Collections.singletonList(scrollId))  // 传入需要清理的 scroll_id
                    .build();

            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest);
            LOGGER.info("Cleared scroll with status: {}", clearScrollResponse.succeeded());

        } catch (IOException e) {
            LOGGER.error("Error clearing scroll", e);
        }
    }

    public static List<SelectedTable> getSelectedTable() throws IOException {
    String selectTable= """
            [{"tableName":"住院患者医嘱信息","table":"srpInOrders","headerList":[{"field":"patientId","fieldName":"病案号","index":1},{"field":"homeId","fieldName":"主页id","index":2},{"field":"hosCaseNum","fieldName":"住院号","index":3},{"field":"medicalOrderNum","fieldName":"医嘱号","index":4},{"field":"medicalGroupNum","fieldName":"医嘱组号","index":5},{"field":"orderAssociationNum","fieldName":"医嘱关联号","index":6},{"field":"orderDoctorName","fieldName":"开医嘱医生名称","index":7},{"field":"orderDoctorNum","fieldName":"开医嘱医生编码","index":8},{"field":"docOrderStatus","fieldName":"医嘱状态","index":9},{"field":"docOrderAging","fieldName":"医嘱期效","index":10},{"field":"medicalCategory","fieldName":"医嘱项目分类","index":11},{"field":"medicalCategoryId","fieldName":"医嘱项目分类id","index":12},{"field":"diagType","fieldName":"诊疗类别","index":13},{"field":"diagTypeId","fieldName":"诊疗类别编码","index":14},{"field":"diagEvent","fieldName":"诊疗项目名称","index":15},{"field":"diagEventId","fieldName":"诊疗项目id","index":16},{"field":"feeBreakdownId","fieldName":"收费细目id","index":17},{"field":"day","fieldName":"天数","index":18},{"field":"docOrderDetail","fieldName":"医嘱内容","index":19},{"field":"skinTestResult","fieldName":"皮试结果","index":20},{"field":"startTime","fieldName":"开始执行时间","index":21},{"field":"endTime","fieldName":"执行终止时间","index":22},{"field":"lastTime","fieldName":"上次执行时间","index":23},{"field":"dachRoom","fieldName":"下达科室","index":24},{"field":"medicalOrderTime","fieldName":"医嘱下达时间","index":25},{"field":"executiveDepartment","fieldName":"执行科室","index":26},{"field":"drugName","fieldName":"药品名称","index":27},{"field":"medicineForm","fieldName":"药物剂型","index":28},{"field":"medicineSpeci","fieldName":"药物规格","index":29},{"field":"medicineFreq","fieldName":"药物使用-频率","index":30},{"field":"medicineTotalDose","fieldName":"药物使用-总剂量","index":31},{"field":"medicineEachDose","fieldName":"药物使用-次剂量","index":32},{"field":"medicineDoseUnit","fieldName":"药物使用-剂量单位","index":33},{"field":"medicineWay","fieldName":"药物使用-途径","index":34},{"field":"medicineStartTime","fieldName":"用药开始时间","index":35},{"field":"medicineEndTime","fieldName":"用药停止时间","index":36},{"field":"medicineApplicationDay","fieldName":"用药天数","index":37},{"field":"dischargeMedicine","fieldName":"是否出院带药(是/否/自备)","index":38}]}]
            """;
         return JSONArray.parseArray(selectTable, SelectedTable.class);
    }



    private static   void  testExport(   ExcelWriter writer,List<SrpWideTableDeSerial> results,List<SelectedTable> selectedTableList,   HashMap<String, Integer> sizeMap ) {
        // 获取 SrpWideTableDeSerial 类中的所有 List 类型属性
        Field[] fields = SrpWideTableDeSerial.class.getDeclaredFields();
        SrpWideTableDeSerial srpWideTableDeSerial = new SrpWideTableDeSerial();
        for (Field field : fields) {
            if (List.class.isAssignableFrom(field.getType())) {
                // 获取当前属性的所有数据
                field.setAccessible(true);
                List<Object> mergedData = new ArrayList<>();
                for (SrpWideTableDeSerial obj : results) {
                    List<?> fieldData = null;
                    try {
                        fieldData = (List<?>) field.get(obj);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    if (fieldData != null) {
                        mergedData.addAll(fieldData);
                    }
                    try {
                        field.set(srpWideTableDeSerial, mergedData);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }

            }


        }


        try (writer) {
            for (SelectedTable selectedTable : selectedTableList) {
                String sheetName = selectedTable.getTableName();
                // 根据字段名获取数据
                List<?> fieldData = extractFieldData(srpWideTableDeSerial, selectedTable.getTable());
                if (CollectionUtils.isEmpty(fieldData)) {
                    continue;
                }
                // 动态生成表头和数据
                List<List<String>> headers = generateHeaders(selectedTable.getHeaderList());
                List<List<Object>> rows = generateRows(fieldData, selectedTable.getHeaderList());

                // 创建 Sheet
                if (sizeMap.containsKey(selectedTable.getTableName())) {
                    sizeMap.compute(selectedTable.getTableName(), (k, oldSize) -> oldSize + rows.size());
                    sizeMap.put(selectedTable.getTableName() + "CurrentSheetIndex", 0);
                } else {
                    sizeMap.put(selectedTable.getTableName(), rows.size());
                }
                if (sizeMap.get(selectedTable.getTableName()) > MAX_ROWS_PER_SHEET) {
                    sizeMap.compute(selectedTable.getTableName() + "CurrentSheetIndex", (k, currentSheetIndex) -> currentSheetIndex + 1);
                    sheetName = selectedTable.getTableName() + sizeMap.get(selectedTable.getTableName() + "CurrentSheetIndex");
                }

                WriteSheet excelWriter = EasyExcel.writerSheet(sheetName).head(headers).build();
                // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
                writer.write(rows, excelWriter);
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            }

        }

    }
        // 提取字段数据
        private static List<?> extractFieldData(SrpWideTableDeSerial data, String fieldName) {
            try {
                var field = SrpWideTableDeSerial.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (List<?>) field.get(data);
            } catch (Exception e) {
                return Collections.emptyList();
            }
        }

        // 动态生成表头
        private static  List<List<String>> generateHeaders(List<SelectedField> subFields) {
            List<List<String>> headers = new ArrayList<>();
            subFields.sort(Comparator.comparingInt(SelectedField::getIndex));
            for (SelectedField subField : subFields) {
                headers.add(List.of(subField.getFieldName()));
            }
            return headers;
        }

        // 动态生成数据行
        private static List<List<Object>> generateRows(List<?> fieldData, List<SelectedField> subFields) {
            List<List<Object>> rows = new ArrayList<>();
            if (fieldData == null || fieldData.isEmpty()) {
                return rows;
            }

            for (Object item : fieldData) {
                List<Object> row = new ArrayList<>();
                for (SelectedField subField : subFields) {
                    try {
                        var field = item.getClass().getDeclaredField(subField.getField());
                        field.setAccessible(true);
                        row.add(field.get(item));
                    } catch (Exception e) {
                        row.add(null); // 如果无法获取字段值，填充 null
                    }
                }
                rows.add(row);
            }
            return rows;
        }


}
