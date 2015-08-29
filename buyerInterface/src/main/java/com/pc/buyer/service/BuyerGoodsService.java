package com.pc.buyer.service;

import com.pc.buyer.model.BuyerGoods;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 买手与商品的关联
 * @date 2015/8/20
 */
public interface BuyerGoodsService {

    //查询所有买手与商品
    public List<BuyerGoods> listAll();

    //查询商品ID查询
    public BuyerGoods getByGoodsId(Integer id);

    //通过买手ID查询
    public List<BuyerGoods> getByBuyerId(Integer id);

}
