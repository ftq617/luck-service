package com.luke.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.scripts.JS;

/**
 * @ClassName: JsonUtils
 * @Description:
 * @Author: Luke Fu
 * @Date: 2020/09/16 15:31
 **/
public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJSONString(Object jsonObj) {
        return gson.toJson(jsonObj);
    }

    public static <T> T paserObject(String data, Class<T> clazz) {
        return gson.fromJson(data, clazz);
    }

    public static JsonObject paserObject(String data) {
        return new JsonParser().parse(data).getAsJsonObject();
    }

}
