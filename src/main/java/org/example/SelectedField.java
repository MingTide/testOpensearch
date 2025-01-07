package org.example;


import lombok.Data;

@Data
public class SelectedField {
    Integer index;
    /**
     * 字段名
     */
    String field;
    String fieldName;
}
