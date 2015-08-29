package com.pc.buyer.business;

import com.pc.buyer.model.from.GoodsInfoForm;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business
 * @Des: 商品业务逻辑处理
 * @date 2015/8/20
 */

public interface GoodsInfoBusiness {

    // 获取商品详情
    public GoodsInfoForm getGoodsInfo(Integer id);
}
