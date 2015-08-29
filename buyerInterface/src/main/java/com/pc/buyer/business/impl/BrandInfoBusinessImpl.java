package com.pc.buyer.business.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pc.buyer.business.BrandInfoBusiness;
import com.pc.buyer.model.GoodsInfo;
import com.pc.buyer.model.PcBrandInfo;
import com.pc.buyer.service.GoodsInfoService;
import com.pc.buyer.service.PcBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business.impl
 * @Des: 商铺信息处理
 * @date 2015/8/22
 */
@Service
public class BrandInfoBusinessImpl implements BrandInfoBusiness {

    @Autowired
    private PcBrandInfoService pcBrandInfoService;
    @Autowired
    private GoodsInfoService goodsInfoService;
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


    @Override
    public JsonObject getBrandInfoById(Integer id) {
        if (id==null){
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        PcBrandInfo brandInfo = pcBrandInfoService.getById(id);
        JsonArray goodsInfos = new JsonArray();
        if (brandInfo != null) {
            List<GoodsInfo> goodses = goodsInfoService.getByBrandId(brandInfo.getId());
            if (goodses != null && goodses.size() > 0) {
                for (GoodsInfo goodsInfo : goodses) {
                        JsonObject goodsJson= new JsonObject();
                        goodsJson.addProperty("id",goodsInfo.getId());
                        goodsJson.addProperty("goodsName",goodsInfo.getGoodsName());
                        goodsJson.addProperty("finalPrice",goodsInfo.getFinalPrice());
                        goodsJson.addProperty("purPrice",goodsInfo.getPurPrice());
                        goodsJson.addProperty("shippingPrice",goodsInfo.getShippingPrice());
                        goodsJson.addProperty("islike",goodsInfo.getId());//TODO
                        goodsJson.addProperty("brandId",goodsInfo.getBrandId());
                        goodsInfos.add(goodsJson);
                }
            }
        }
        jsonObject.add("bgsbinfo", gson.toJsonTree(brandInfo));
        jsonObject.add("goodsInfos", goodsInfos);
        return jsonObject;
    }
}
