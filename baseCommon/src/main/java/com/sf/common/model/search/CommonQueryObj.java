package com.sf.common.model.search;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by YNzF on 2015/8/20.
 */
public class CommonQueryObj {
    private QueryStr queryStr;
    private int stype;
    private int start;
    private int size;
    private List<QueryFilter> filter;
    private List<QuerySort> sort;

    public QueryStr getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(QueryStr queryStr) {
        this.queryStr = queryStr;
    }

    public int getStype() {
        return stype;
    }

    public void setStype(int stype) {
        this.stype = stype;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<QueryFilter> getFilter() {
        return filter;
    }

    public void setFilter(List<QueryFilter> filter) {
        this.filter = filter;
    }

    public List<QuerySort> getSort() {
        return sort;
    }

    public void setSort(List<QuerySort> sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "CommonQueryObj{" +
                "queryStr='" + queryStr + '\'' +
                ", stype='" + stype + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", filter=" + filter +
                ", sort=" + sort +
                '}';
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"queryStr\": {\"field\": 1, \"val\": \"xxxx\"},\n" +
                "  \"stype\": 0,\n" +
                "  \"start\": 0,\n" +
                "  \"size\": 10,\n" +
                "  \"filter\": [\n" +
                "    {\n" +
                "      \"field\": 1,\n" +
                "      \"val\": \"xxxx\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"field\": 2,\n" +
                "      \"val\": \"xxxx\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"sort\": [\n" +
                "    {\n" +
                "      \"field\": 1,\n" +
                "      \"order\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"field\": 2,\n" +
                "      \"order\": 0\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        CommonQueryObj query = new Gson().fromJson(json, CommonQueryObj.class);
        System.out.println(query);
    }
}
