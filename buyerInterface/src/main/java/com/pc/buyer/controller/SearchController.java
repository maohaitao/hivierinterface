package com.pc.buyer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pc.buyer.business.SearchBusiness;
import com.pc.buyer.model.GoodsInfo;
import com.pc.buyer.service.GoodsInfoService;
import com.sf.common.log.LogService;
import com.sf.common.model.CommonRequest;
import com.sf.common.model.DynamicResult;
import com.sf.common.model.search.*;
import com.sf.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.sf.mall.controller
 * @Des: 搜索的接口
 * @date 2015/8/17
 */
@Controller
public class SearchController extends BaseController {

    @Autowired
    private SearchBusiness searchBusiness;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Override
    public DynamicResult handleBusiness(CommonRequest r) throws Exception {
        Long l1 = System.currentTimeMillis();
        String url = r.getRequest().getRequestURI();
        DynamicResult re = null;
        if (url.indexOf("search_key") > 0) {
            re = searchKeyDeal(r);
        } else if (url.indexOf("search_index") > 0) {
            re = searchIndexDeal(r);
        }
        Long l2 = System.currentTimeMillis();
        LogService.info("all time:" + (l2 - l1));
        return re;
    }

    /**
     * 获取索引接口
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/search_key.shtml")
    public void searchKey(HttpServletRequest request, HttpServletResponse response) {
        try {
            dealService(request, response);
        } catch (IOException e) {
            LogService.error("searchKey：", e);
        }
    }

    /**
     * 处理返回的key列表
     *
     * @param r
     * @return
     */
    public DynamicResult searchKeyDeal(CommonRequest r)  throws  Exception{
        DynamicResult result = new DynamicResult();
        JsonObject dataJo = r.getJsonData();
        String key = JsonUtil.getValue(dataJo, "searchkey");
        SearchResultWrapper keys = null;
        keys = searchBusiness.searchKey(key);
        if (keys!=null){
            result.put("searchkeys", new Gson().toJsonTree(keys.getResults()));
        }
        return result;
    }

    /**
     * 搜索处理接口
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/search_index.shtml")
    public void searchIndex(HttpServletRequest request, HttpServletResponse response) {
        try {
            dealService(request, response);
        } catch (IOException e) {
            LogService.error("searchIndex：", e);
        }
    }

    private int searchSize = 10; // 默认搜索返回的条数

    public DynamicResult searchIndexDeal(CommonRequest r) throws  Exception{
        DynamicResult result = new DynamicResult();
        JsonObject dataJo = r.getJsonData();
        String key = JsonUtil.getValue(r.getJsonData(), "searchkey");
        int searchNum = JsonUtil.getValue(r.getJsonData(), "searchNum", 0);
        int keysrc = JsonUtil.getValue(r.getJsonData(), "keysrc", 0);
        int size = JsonUtil.getValue(dataJo, "size", 0);
        int sType = JsonUtil.getValue(dataJo, "sType", 0);
        size = size == 0 ? searchSize : size;

        CommonQueryObj obj = new CommonQueryObj();
        QueryStr queryStr = new QueryStr();
        queryStr.setField(sType+"");
        queryStr.setVal(key);
        obj.setQueryStr(queryStr);
        obj.setSize(size);
        obj.setStype(sType);
        obj.setStart(searchNum);

        SearchResultWrapper keys = searchBusiness.searchIndex(obj);//.searchIndex(dataJo); // TODO 解析返回的json对象
        JsonArray list = new JsonArray();
        result.put("searchNum", searchNum);
        if (keys!=null){
            result.put("searchNum", searchNum+size);
            result.put("countnum", keys.getNumFound());
            List<ComoditesRs> res = keys.getResults();
            if (res!=null && res.size()>0){
                for (ComoditesRs re:res){
                    if (re!=null && re.getStype().equals("1")){
                        GoodsInfo form = goodsInfoService.getById(Integer.parseInt(re.getCid()));
                        if (form!=null){
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("id", re.getStype());
                            jsonObject.addProperty("srctype", form.getId());
                            jsonObject.addProperty("islike", "0");
                            jsonObject.addProperty("icon", "--------------");
                            jsonObject.addProperty("brandicon", "--------------");
                            jsonObject.addProperty("goodsname",form.getGoodsName());
                            jsonObject.addProperty("finalprice", "555");
                            list.add(jsonObject);
                        }
                    }
                }
            }
        }
        result.put("searchs", list);
        return result;
    }
}
