/**
 * @Title: DynamicResult.java
 * @Package com.pb.model
 * @author maohaitao
 * @date 2015年4月2日 下午5:39:54
 * @version V1.0
 */
package com.sf.common.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maohaitao
 * @ClassName: DynamicResult
 * @Des: 动态结果：用于servlet不确定具体属性的情况下返回结果
 * @date 2015年4月2日 下午5:39:54
 */
public class DynamicResult {

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    private JsonObject innerResult = new JsonObject();

    public boolean isEmpty() {
        return innerResult.entrySet().isEmpty();
    }

    public JsonObject toJson() {
        return innerResult;
    }

    public static DynamicResult parse(Object value) {
        return new DynamicResult().put(value);
    }

    public static DynamicResult parse(JsonObject value) {
        return new DynamicResult().put(value);
    }

    public static DynamicResult parse(Map<String, Object> value) {
        return new DynamicResult().put(value);
    }

    public DynamicResult put(String key, String value) {
        innerResult.addProperty(key, value);
        return this;
    }

    public DynamicResult put(String key, Number value) {
        if (key == null || value == null) {
            return null;
        }
        innerResult.addProperty(key, value);
        return this;
    }

    public DynamicResult put(String key, Boolean value) {
        if (key == null || value == null) {
            return null;
        }
        innerResult.addProperty(key, value);
        return this;
    }

    public DynamicResult put(String key, JsonElement value) {
        if (key == null || value == null) {
            return null;
        }
        innerResult.add(key, value);
        return this;
    }

    public DynamicResult put(String key, Object value) {
        if (key == null || value == null) {
            return null;
        }
        innerResult.add(key, objectToJson(value));
        return this;
    }

    public DynamicResult put(Object value) {
        return put(objectToJson(value));
    }

    public DynamicResult put(JsonObject json) {
        return put(json, false);
    }

    public DynamicResult put(JsonObject json, boolean skipIfExists) {
        for (Map.Entry<String, JsonElement> item : json.entrySet()) {
            if (skipIfExists && innerResult.has(item.getKey())) {
                continue;
            }
            innerResult.add(item.getKey(), item.getValue());
        }

        return this;
    }

    public DynamicResult put(Map<String, Object> map) {
        for (String key : map.keySet()) {
            Object val = map.get(key);
            if (val == null) {
                innerResult.addProperty(key, (String) null);
            } else if (val instanceof JsonElement) {
                innerResult.add(key, (JsonElement) val);
            } else {
                innerResult.addProperty(key, val.toString());
            }
        }

        return this;
    }

    public boolean has(String key) {
        return innerResult.has(key);
    }

    public String getValue(String key) {
        if (!has(key)) {
            return null;
        }

        JsonElement element = innerResult.get(key);
        if (element == null) {
            return null;
        }

        return element.getAsString();
    }

    public String popValue(String key) {
        if (!has(key)) {
            return null;
        }

        JsonElement element = innerResult.remove(key);
        if (element == null) {
            return null;
        }
        return element.getAsString();
    }

    public Integer popInt(String key) {
        if (!has(key)) {
            return null;
        }

        JsonElement element = innerResult.remove(key);
        if (element == null) {
            return null;
        }

        return element.getAsInt();
    }

    public Integer getAsInt(String key) {
        if (!has(key)) {
            return null;
        }

        JsonElement element = innerResult.get(key);
        if (element == null) {
            return null;
        }

        return element.getAsInt();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        for (Map.Entry<String, JsonElement> item : innerResult.entrySet()) {
            map.put(item.getKey(), item.getValue().getAsString());
        }

        return map;
    }

    private JsonObject objectToJson(Object value) {
        return (JsonObject) gson.toJsonTree(value);
    }

    @Override
    public String toString() {
        return gson.toJson(innerResult);
    }

}
