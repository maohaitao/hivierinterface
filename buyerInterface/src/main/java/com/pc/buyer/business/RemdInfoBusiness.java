package com.pc.buyer.business;

import com.google.gson.JsonObject;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business
 * @Des: 首页数据下发
 * @date 2015/8/21
 */
public interface RemdInfoBusiness {

    //获取首页的数据
    public JsonObject remdInfo(String typeid,String mark,Integer must);
}
