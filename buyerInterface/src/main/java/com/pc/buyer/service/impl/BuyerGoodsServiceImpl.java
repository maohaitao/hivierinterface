package com.pc.buyer.service.impl;

import com.pc.buyer.model.BuyerGoods;
import com.pc.buyer.service.BuyerGoodsService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 买手与商品的关联 service 处理
 * @date 2015/8/20
 */
@Service
public class BuyerGoodsServiceImpl implements BuyerGoodsService {

    @Autowired
    private BaseDaoImpl<BuyerGoods> dao;

    @Override
    public List<BuyerGoods> listAll() {
        List<BuyerGoods> list = null;
        BuyerGoods buyerGoods = new BuyerGoods();
//        goodsInfo.setgStatus(2);
        try {
            list = dao.list(buyerGoods);
        } catch (AppException e) {
            LogService.error("listAll,查询所有关联商品失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public BuyerGoods getByGoodsId(Integer id) {
        BuyerGoods buyerGoods = null;//CacheModel.getGoodsInfo(id + "");
        if (buyerGoods == null) {
            buyerGoods = new BuyerGoods();
            buyerGoods.setGoodsId(id);
            try {
                buyerGoods = dao.get(buyerGoods, "goodsId");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getByGoodsId,查询买家关联的商品失败:", e);
                return null;
            }
        }
        return buyerGoods;
    }


    @Override
    public List<BuyerGoods> getByBuyerId(Integer id) {
        List<BuyerGoods> buyerGoodses = new ArrayList<>();//CacheModel.getGoodsInfo(id + "");
        if (id!= null) {
            BuyerGoods buyerGoods = new BuyerGoods();
            buyerGoods.setBuyerId(id);
            try {
                buyerGoodses = dao.list(buyerGoods, "buyerId");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getByBuyerId,查询买家关联的商品失败:", e);
                return null;
            }
        }
        return buyerGoodses;
    }
}
