/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.*;

import java.io.IOException;
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

        // 处理第一批返回的数据
        searchResponse.hits().hits().forEach(hit -> {
            // 这里处理每条文档数据
            atomicInt.getAndIncrement();
        });

        // 继续查询剩余的数据
        while (true) {

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
            });
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


}
