package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultiFormatDateDeserializer extends JsonDeserializer<Date> {
    private static final List<SimpleDateFormat> dateFormats = new ArrayList<>();

    static {
        // 添加支持的时间格式
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX")); // 带时区
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));      // ISO 标准时间
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));       // 常规时间
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));                // 日期格式
    }

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String dateValue = parser.getText();
        for (SimpleDateFormat dateFormat : dateFormats) {
            try {
                return dateFormat.parse(dateValue);
            } catch (ParseException e) {

            }

        }
        throw new IOException("Unparseable date: " + dateValue);
    }
}