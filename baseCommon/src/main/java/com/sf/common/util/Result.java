package com.sf.common.util;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sf.common.constant.ResultErrorCode;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private int status = ResultErrorCode.STATUS_CODE_SERVER_ERROR.getCode();
    private int errorcode;
    private boolean hasnew = false;
    private String mark = "";
    private String message = "";
    private final Map<String, Object> keys = new HashMap<String, Object>();

    public void put(String key, Object value) {
        keys.put(key, value);
    }

    private String getData() {
        JsonObject data = new JsonObject();
        JsonObject result = new JsonObject();
        result.addProperty("status", getStatus());
        result.addProperty("errorcode", getErrorcode());
        result.addProperty("servertime", System.nanoTime());
        result.addProperty("hasnew", getHasnew());
        result.addProperty("mark", getMark());
        result.addProperty("msg", getMessage());
        data.add("result", result);
        for (Map.Entry<String, Object> entry : keys.entrySet()) {
            if (entry.getValue() instanceof JsonElement) {
                data.add(entry.getKey(), (JsonElement) entry.getValue());
            } else {
                data.addProperty(entry.getKey(), String.valueOf(entry.getValue()));
            }

        }
        return data.toString();
    }

    public Result paramError(ResultErrorCode errorCode) {
        setStatus(ResultErrorCode.STATUS_CODE_PARAM_ERROR.getCode());
        setErrorcode(errorCode.getCode());
        setMessage(errorCode.getMessage());
        return this;
    }

    public Result businessError(ResultErrorCode errorCode) {
        setStatus(ResultErrorCode.STATUS_CODE_BUSINESS_ERROR.getCode());
        setErrorcode(errorCode.getCode());
        setMessage(errorCode.getMessage());
        return this;
    }

    public Result success() {
        setStatus(ResultErrorCode.STATUS_CODE_SUCCESS.getCode());
        return this;
    }


    public int getStatus() {
        return status;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public boolean getHasnew() {
        return hasnew;
    }

    public String getMark() {
        return mark;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public void setHasnew(boolean hasnew) {
        this.hasnew = hasnew;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return getData();
    }
}
