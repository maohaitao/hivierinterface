package com.pc.buyer.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.pc.buyer.business.BrandInfoBusiness;
import com.pc.buyer.business.BuyerShopInfoBusiness;
import com.pc.buyer.business.GoodsInfoBusiness;
import com.pc.buyer.service.PcBrandInfoService;
import com.sf.common.log.LogService;
import com.sf.common.model.CommonRequest;
import com.sf.common.model.DynamicResult;
import com.sf.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hesin
 * @Created with： com.pc.buyer.controller
 * @Des: 品牌/商品/商铺/买手详细信息
 * @date 2015/8/18
 */
@Controller
@RequestMapping("/bgsbinfo_query.shtml")
public class BGSBInfoController extends BaseController {

    @Autowired
    private GoodsInfoBusiness goodsInfoBunsiness;
    @Autowired
    private BrandInfoBusiness brandInfoBusiness;
    @Autowired
    private BuyerShopInfoBusiness buyerShopInfoBunsiness;

    @Override
    public DynamicResult handleBusiness(CommonRequest r) throws Exception {
        DynamicResult result = new DynamicResult();
        JsonObject dataJo = r.getJsonData();
        Integer id = JsonUtil.getValue(dataJo, "id", 0);
        int iType = JsonUtil.getValue(dataJo, "iType", 0); // 1、商品名称  2 商品品类 3 品牌名称 4买手店铺
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if (iType == 1) {
            Object object = goodsInfoBunsiness.getGoodsInfo(id);
            result.put(gson.toJsonTree(object));
        } else if (iType == 3) {
            JsonObject jsonObject = brandInfoBusiness.getBrandInfoById(id);
            result.put(jsonObject);
        } else if (iType == 4) {
            JsonObject jsonObject = buyerShopInfoBunsiness.getBuyerShopInfo(id);
            result.put(jsonObject);
        } // TODO 其他详情
        return result;
    }

    @RequestMapping
    public void BGSBInfoQuery(HttpServletRequest request, HttpServletResponse response) {
        try {
            dealService(request, response);
        } catch (IOException e) {
            LogService.error("BGSBInfoQuery,查询详情失败：", e);
        }
    }

}
