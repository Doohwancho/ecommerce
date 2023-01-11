package com.cho.ecommerce.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonUtils {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GsonUtils.class);

    private static String PATTERN_DATE = "yyyy-MM-dd";
    private static String PATTERN_TIME = "HH:mm:ss";
    private static String PATTERN_DATETIME = String.format("%s %s", PATTERN_DATE, PATTERN_TIME);

    private static Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat(PATTERN_DATETIME)
            .create();

    public static String toJson(Object o) {
        String result = gson.toJson(o);
        if("string".equals(result))
            return null;
        return result;
    }

    public static <T> T fromJson(String s, Class<T> clazz) {
        try {
            return gson.fromJson(s, clazz);
        } catch(JsonSyntaxException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
