package com.pc.buyer.business.impl;

import com.pc.buyer.business.GoodsInfoBusiness;
import com.pc.buyer.model.*;
import com.pc.buyer.model.from.GoodsInfoForm;
import com.pc.buyer.service.*;
import com.pc.buyer.service.impl.GoodsDetailsServiceImpl;
import com.pc.buyer.service.impl.GoodsStockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business.impl
 * @Des: 商品的业务处理
 * @date 2015/8/20
 */
@Service
public class GoodsInfoBunsinessImpl implements GoodsInfoBusiness {

    @Autowired
    private GoodsInfoService goodsInfoService;
    @Autowired
    private BuyerGoodsService buyerGoodsService;
    @Autowired
    private PcBuyerInfoService pcBuyerInfoService;
    @Autowired
    private GoodsDetailsServiceImpl goodsDetailsService;
    @Autowired
    private PcBrandInfoService pcBrandInfoService;
    @Autowired
    private GoodsStockServiceImpl goodsStockService;

    @Override
    public GoodsInfoForm getGoodsInfo(Integer id) {
        GoodsInfoForm form = new GoodsInfoForm();
        GoodsInfo goodsInfo = null;
        PcBuyerInfo buyerInfo = null;
        GoodsDetails details = null;
        PcBrandInfo brandInfo = null;
        List<Map<String, Map<String, Object>>> maps = new ArrayList<>();
        if (id != null) {
            goodsInfo = goodsInfoService.getById(id);
            if (goodsInfo != null) {
                BuyerGoods buyerGoods = buyerGoodsService.getByGoodsId(goodsInfo.getId());
                if (buyerGoods != null) {
                    buyerInfo = pcBuyerInfoService.getById(buyerGoods.getGoodsId());
                }
                details = goodsDetailsService.getGoodsDetailsByGoodsId(goodsInfo.getId());
                brandInfo = pcBrandInfoService.getById(goodsInfo.getBrandId());
                List<GoodsStock> goodsStocks = goodsStockService.getStockByGoodsId(goodsInfo.getId());
                if (goodsStocks != null && goodsStocks.size() > 0) {
                    Map<String, Map<String, Object>> map = new HashMap<>();
                    for (GoodsStock goodsStock : goodsStocks) {
                        Map<String, Object> coloes = new HashMap<>();
                        if (goodsInfo.getStock() == 0) {
                            goodsStock.setStock(-1);
                        }
                        if (map.containsKey(goodsStock.getColor())) {
                            coloes = map.get(goodsStock.getColor());
                        }
                        coloes.put(goodsStock.getSize(), goodsStock);
                        map.put(goodsStock.getColor(), coloes);
                    }
                    maps.add(map);
                }
            }
        }
        form.setBgsbinfo(goodsInfo);
        form.setBuyer(buyerInfo);
        form.setGoodsDetails(details);
        form.setPcBrandInfo(brandInfo);
        form.setColorsize(maps);        // TODO 购买弹框提示颜色尺码
        return form;
    }
}
