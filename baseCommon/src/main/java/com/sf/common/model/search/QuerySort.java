package com.sf.common.model.search;

/**
 * Created by YNzF on 2015/8/20.
 */
public class QuerySort {
    private String field;
    private int order;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "QuerySort{" +
                "field='" + field + '\'' +
                ", order=" + order +
                '}';
    }
}
