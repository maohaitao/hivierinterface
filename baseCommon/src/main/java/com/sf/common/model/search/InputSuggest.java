package com.sf.common.model.search;


import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by YNzF on 2015/8/19.
 */
public class InputSuggest extends SearchResultBase {
    //数据源：商品名称(1)  商品品类(2) 品牌名称(3)
    private String ds;
    //数据库表的ID,和ds一起确定唯一的内容
    private String id;
    //显示的字符串
    private String name;

    public InputSuggest() {
    }

    public String getDs() {
        return ds;
    }

    @Field("ds")
    public void setDs(String ds) {
        this.ds = ds;
    }

    public String getName() {
        return name;
    }

    @Field("display_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Field("inner_id")
    public void setId(String id) {
        this.id = id;
    }
}
