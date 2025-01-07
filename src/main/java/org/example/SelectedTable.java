package org.example;

import lombok.Data;

import java.util.List;


@Data
public class SelectedTable {
    /**
     * 表名字
     */
    String table;
    /**
     *表中文名
     */
    String tableName;
    /**
     * 字段名字
     */
    List<SelectedField> headerList;


}
