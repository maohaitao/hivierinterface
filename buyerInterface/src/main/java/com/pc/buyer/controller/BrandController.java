package com.pc.buyer.controller;

import com.google.gson.Gson;
import com.pc.buyer.cache.RedisCacheService;
import com.pc.buyer.cache.RedisService;
import com.pc.buyer.model.BrandCate;
import com.pc.buyer.model.PcBrandInfo;
import com.pc.buyer.model.PcCateInfo;
import com.pc.buyer.service.BrandCateService;
import com.pc.buyer.service.PcBrandInfoService;
import com.pc.buyer.service.PcCateInfoService;
import com.sf.common.log.LogService;
import com.sf.common.model.CommonRequest;
import com.sf.common.model.DynamicResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.controller
 * @Des: 品牌的首页
 * @date 2015/8/18
 */
@Controller
public class BrandController extends BaseController {

    @Autowired
    private PcCateInfoService pcCateInfoService;
    @Autowired
    private BrandCateService brandCateService;
    @Autowired
    private PcBrandInfoService pcBrandInfoService;

    @Override
    public DynamicResult handleBusiness(CommonRequest r) throws Exception {
        return searchKeyDeal(r);
    }

    @RequestMapping("/brandinfo_query.shtml")
    public void brandQuery(HttpServletRequest request, HttpServletResponse response) {
        try {
            dealService(request, response);
        } catch (IOException e) {
            LogService.error("brandQuery：", e);
        }
    }

    public DynamicResult searchKeyDeal(CommonRequest r) {
        DynamicResult result = new DynamicResult();
        List<PcCateInfo> cateInfos = pcCateInfoService.listAll();
        List<PcBrandInfo> list = pcBrandInfoService.listAll();
        result.put("brands", RedisService.getJedisCache().hgetAll(RedisCacheService.BRAND_INFO_MAP_KEY));

        if (cateInfos != null && cateInfos.size() > 0) { // TODO 缓存优化
            for (PcCateInfo cateInfo : cateInfos) {
                if (cateInfo != null) {
                    List<Integer> brandIds = new ArrayList<>();
                    List<BrandCate> brandCates = brandCateService.getById(cateInfo.getId() + "");
                    if (brandCates != null) {
                        for (BrandCate brandCate : brandCates) {
                            brandIds.add(brandCate.getBrandId());
                        }
                        cateInfo.setBrandIds(brandIds);
                    }
                }
            }
            result.put("cateInfos", new Gson().toJsonTree(cateInfos));
        }
        return result;
    }

}
