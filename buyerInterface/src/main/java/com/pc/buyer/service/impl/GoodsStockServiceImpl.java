package com.pc.buyer.service.impl;

import com.pc.buyer.model.GoodsStock;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 商品库存信息
 * @date 2015/8/25
 */
@Service
public class GoodsStockServiceImpl extends BaseService {

    /**
     * 获取商品颜色尺码
     * @param goodsid
     * @return
     */
    public List<GoodsStock> getStockByGoodsId(Integer goodsid){
        if (goodsid==null){
            return null;
        }
        List<Object> params = new ArrayList<>();
        params.add(goodsid);
        params.add(3);
        String sql="select * from goods_stock d where exists(select 1 from goods_info g where g.id=d.goods_id and g.id=? and g.g_status=?) ";
        List<GoodsStock> goodsStocks = null;
        try {
            goodsStocks = queryBySQL(sql, GoodsStock.class, params);
        } catch (AppException e) {
            LogService.error("getStockByGoodsId,error:",e);
        }
        return goodsStocks;
    }
}
