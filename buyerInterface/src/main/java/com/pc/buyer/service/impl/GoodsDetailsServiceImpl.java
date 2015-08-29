package com.pc.buyer.service.impl;

import com.pc.buyer.model.GoodsDetails;
import com.sf.common.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 商品详情业务处理
 * @date 2015/8/22
 */
@Service
public class GoodsDetailsServiceImpl extends BaseService {

    /**
     * 获取商品图文详情
     * @param goodsid
     * @return
     */
    public GoodsDetails getGoodsDetailsByGoodsId(Integer goodsid){
        if (goodsid==null){
            return null;
        }
        List<Object> params = new ArrayList<>();
        params.add(goodsid);
        params.add(3);
        params.add(3);
        String sql="select * from goods_details d where exists(select 1 from goods_info g where g.id=d.goods_id and g.id=? and g.g_status=?) and d.g_status=?";
        GoodsDetails goodsDetails = findBySQL(sql,GoodsDetails.class,params);
        return goodsDetails;
    }

}
