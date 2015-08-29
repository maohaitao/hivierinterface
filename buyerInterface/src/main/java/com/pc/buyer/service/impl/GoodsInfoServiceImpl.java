package com.pc.buyer.service.impl;

import com.pc.buyer.cache.RedisCacheService;
import com.pc.buyer.model.GoodsInfo;
import com.pc.buyer.model.PcBuyerInfo;
import com.pc.buyer.service.GoodsInfoService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 商品的业务处理
 * @date 2015/8/18
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    BaseDaoImpl<GoodsInfo> dao;

    @Override
    public List<GoodsInfo> listAll() {
        List<GoodsInfo> list = null;
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setgStatus(3);
        try {
            list = dao.list(goodsInfo, "gStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线商品失败:", e);
            return null;
        }
        return list;
    }

    RedisCacheService redisCacheService = new RedisCacheService<PcBuyerInfo>();

    @Override
    public GoodsInfo getById(Integer id) {
        GoodsInfo goodsInfo = (GoodsInfo) redisCacheService.get(RedisCacheService.GOODS_INFO_KEY, id + "", GoodsInfo.class);
        if (goodsInfo == null) {
            goodsInfo = new GoodsInfo();
            goodsInfo.setgStatus(3);
            goodsInfo.setId(id);
            try {
                goodsInfo = dao.get(goodsInfo, "id", "gStatus");
                redisCacheService.set(goodsInfo, RedisCacheService.GOODS_INFO_KEY, 0);
            } catch (AppException e) {
                LogService.error("getById,查询上线商品失败:", e);
                return null;
            }
        }
        return goodsInfo;

    }

    @Override
    public List<GoodsInfo> getByBrandId(Integer brandid) {
        if (brandid==null || brandid==0){
            return  null;
        }
        List<GoodsInfo> list = null;
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setgStatus(3);
        goodsInfo.setBrandId(brandid);
        try {
            list = dao.list(goodsInfo, "gStatus","brandId");
        } catch (AppException e) {
            LogService.error("getByBrandId,查询所有上线商品失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public boolean listUpdate(Date time) {
        List<GoodsInfo> list = null;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM goods_info where g_status=? and update_time>=?";
            list = dao.list(sql, GoodsInfo.class, 3, time);
        } catch (AppException e) {
            LogService.error("listUpdate,查询增量修改商品失败:", e);
            return false;
        }
        if (list != null) {
            for (GoodsInfo goodsInfo : list) {
                redisCacheService.set(goodsInfo, RedisCacheService.GOODS_INFO_KEY, 0);
            }
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean listCancel(Date time) {
        List<GoodsInfo> list = null;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM goods_info where g_status=? and update_time>=?";
            list = dao.list(sql, GoodsInfo.class, 4, time);
        } catch (AppException e) {
            LogService.error("listUpdate,查询增量修改商品信息失败:", e);
            return false;
        }
        if (list != null) {
            for (GoodsInfo goodsInfo : list) {
                redisCacheService.set(goodsInfo, RedisCacheService.GOODS_INFO_KEY, 0);
            }
            flag = true;
        }
        return flag;
    }
}
