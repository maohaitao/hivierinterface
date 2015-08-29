/**
 * @Title: JsonUtil.java
 * @Package com.pb.common.util
 * @author maohaitao
 * @date 2015年4月2日 下午6:11:35
 * @version V1.0
 */
package com.sf.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

/**
 * @author hesin
 * @ClassName: JsonUtil
 * @date 2015年4月2日 下午6:11:35
 */
public class JsonUtil {

    private JsonUtil() {

    }

    /**
     * @param json
     * @param propertyKey 属性key
     * @return
     * @Title getValue
     * @Description <p>
     * 获取json值
     * </p>
     */
    public static String getValue(JsonObject json, String propertyKey) {
        return getValue(json, propertyKey, "");
    }

    /**
     * @param json
     * @param propertyKey  属性key
     * @param defaultValue 默认值
     * @return
     * @Title getValue
     * @Description <p>
     * 获取json值
     * </p>
     */
    public static String getValue(JsonObject json, String propertyKey, String defaultValue) {
        if (json == null) {
            return defaultValue;
        }

        int dotIndex = propertyKey.indexOf(".");
        if (dotIndex > 0) {
            String head = propertyKey.substring(0, dotIndex);
            String next = propertyKey.substring(dotIndex + 1);
            JsonObject headNode = json.get(head).getAsJsonObject();
            return getValue(headNode, next, defaultValue);
        }
        if (!json.has(propertyKey)) {
            return defaultValue;
        }
        JsonElement jsonElement = json.get(propertyKey);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return defaultValue;
        }

        if (jsonElement.isJsonObject()) {
            return jsonElement.toString();
        }

        return jsonElement.getAsString();
    }

    public static JsonObject parse(String value) {
        return (JsonObject) new JsonParser().parse(value);
    }

    public static JsonElement parseEle(String value) {
        return  new JsonParser().parse(value);
    }

    public static <T> T parse(String value, Class<T> type) {
        return new Gson().fromJson(value, type);
    }

    public static <T>T fromJson(JsonElement value, Class<T> type) {
        return new Gson().fromJson(value, type);
    }

    /**
     * @param json
     * @param propertyKey  属性key
     * @param defaultValue 默认值
     * @return
     * @Title getValue
     * @Description <p>
     * 获取json值
     * </p>
     */
    public static int getValue(JsonObject json, String propertyKey, int defaultValue) {
        if (json == null || !json.has(propertyKey) || json.get(propertyKey) == null) {
            return defaultValue;
        }

        return json.get(propertyKey).getAsInt();
    }

    /**
     * @param from
     * @param to
     * @Title transfer
     * @Description <p>
     * 从一个Json A对象转移到另一个Json B对象，如果转移的属性已经在B对象中存在，则跳过
     * </p>
     */
    public static void transfer(JsonObject from, JsonObject to) {
        if (from != null) {
            // 其他字段
            for (Map.Entry<String, JsonElement> item : from.entrySet()) {
                if (!to.has(item.getKey())) {
                    to.add(item.getKey(), item.getValue());
                }
            }
        }
    }

    public static JsonElement toJsonTree(Object o) {
        return new Gson().toJsonTree(o);
    }
}
