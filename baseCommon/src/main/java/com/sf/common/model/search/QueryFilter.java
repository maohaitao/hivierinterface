package com.sf.common.model.search;

/**
 * Created by YNzF on 2015/8/20.
 */
public class QueryFilter {
    private String field;
    private String val;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "QueryFilter{" +
                "field='" + field + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
