package com.pc.buyer.business.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pc.buyer.business.BuyerShopInfoBusiness;
import com.pc.buyer.model.BuyerGoods;
import com.pc.buyer.model.GoodsInfo;
import com.pc.buyer.model.PcBrandInfo;
import com.pc.buyer.model.PcBuyerInfo;
import com.pc.buyer.service.BuyerGoodsService;
import com.pc.buyer.service.GoodsInfoService;
import com.pc.buyer.service.PcBrandInfoService;
import com.pc.buyer.service.PcBuyerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business.impl
 * @Des: 商铺详业务处理
 * @date 2015/8/22
 */
@Service
public class BuyerShopInfoBunsinessImpl implements BuyerShopInfoBusiness {
    @Autowired
    private PcBuyerInfoService pcBuyerInfoService;

    @Autowired
    private BuyerGoodsService buyerGoodsService;

    @Autowired
    private PcBrandInfoService pcBrandInfoService;
    @Autowired
    private GoodsInfoService goodsInfoService;


    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Override
    public JsonObject getBuyerShopInfo(Integer buyerid) {
        if (buyerid == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        PcBuyerInfo buyerInfo = pcBuyerInfoService.getById(buyerid);
        JsonArray goodsInfos = new JsonArray();
        Map<Integer,PcBrandInfo> pcBrandInfos = new HashMap<>();
        if (buyerInfo != null) {
            List<BuyerGoods> buyerGoodses = buyerGoodsService.getByBuyerId(buyerInfo.getId());
            if (buyerGoodses != null && buyerGoodses.size() > 0) {
                for (BuyerGoods buyerGoods : buyerGoodses) {
                    GoodsInfo goodsInfo = goodsInfoService.getById(buyerGoods.getGoodsId());
                    if (goodsInfo != null) {
                        JsonObject goodsJson= new JsonObject();
                        goodsJson.addProperty("id",goodsInfo.getId());
                        goodsJson.addProperty("goodsName",goodsInfo.getGoodsName());
                        goodsJson.addProperty("finalPrice",goodsInfo.getFinalPrice());
                        goodsJson.addProperty("purPrice",goodsInfo.getPurPrice());
                        goodsJson.addProperty("shippingPrice",goodsInfo.getShippingPrice());
                        goodsJson.addProperty("islike",goodsInfo.getId());//TODO
                        goodsJson.addProperty("brandId",goodsInfo.getBrandId());
                        goodsJson.addProperty("icon",goodsInfo.getIcon());
                        goodsInfos.add(goodsJson);
                        PcBrandInfo brandInfo = pcBrandInfoService.getById(goodsInfo.getBrandId());
                        if (brandInfo!=null){
                            pcBrandInfos.put(brandInfo.getId(),brandInfo);
                        }
                    }
                }
            }
        }
        jsonObject.add("bgsbinfo", gson.toJsonTree(buyerInfo));
        jsonObject.addProperty("brandnum", pcBrandInfos.size());
        jsonObject.addProperty("goodsnum", goodsInfos.size());
        jsonObject.addProperty("likenum", 12);//TODO 粉丝数量
        jsonObject.addProperty("ordernum", 12);//TODO 成交数量
        jsonObject.add("goodsInfos", gson.toJsonTree(goodsInfos));
        jsonObject.add("pcBrandInfos", gson.toJsonTree(pcBrandInfos));
        return jsonObject;
    }
}
