package com.sf.common.model.search;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by YNzF on 2015/8/20.
 */
public class ComoditesRs extends SearchResultBase {
    private String stype = "1";//1：商品 2:品类 3：品牌
    private String cid;//商品ID

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getCid() {
        return cid;
    }

    @Field("id")
    public void setCid(String cid) {
        this.cid = cid;
    }

}
