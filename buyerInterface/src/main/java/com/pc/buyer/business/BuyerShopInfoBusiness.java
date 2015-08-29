package com.pc.buyer.business;

import com.google.gson.JsonObject;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business
 * @Des: 买手商铺详情业务处理
 * @date 2015/8/22
 */
public interface BuyerShopInfoBusiness {

    public JsonObject getBuyerShopInfo(Integer buyerid);
}
