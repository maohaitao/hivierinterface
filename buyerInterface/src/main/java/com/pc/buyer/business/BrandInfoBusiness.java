package com.pc.buyer.business;

import com.google.gson.JsonObject;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business
 * @Des: 品牌信息处理
 * @date 2015/8/22
 */
public interface BrandInfoBusiness {

    public JsonObject getBrandInfoById(Integer id);

}
