package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcSrcGoods;
import com.pc.buyer.service.PcSrcGoodsService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 资源对应的商品
 * @date 2015/8/20
 */
@Service
public class PcSrcGoodsServiceImpl implements PcSrcGoodsService {
    @Autowired
    BaseDaoImpl<PcSrcGoods> dao;

    @Override
    public List<PcSrcGoods> listAll() {
        List<PcSrcGoods> list = null;
        PcSrcGoods pcSrcGoods = new PcSrcGoods();
        pcSrcGoods.settStatus(2);
        try {
            list = dao.list(pcSrcGoods, "tStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线分类对应的商品失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public PcSrcGoods getById(Integer id) {
        PcSrcGoods pcSrcGoods = null;//CacheModel.getGoodsInfo(id);
        if (pcSrcGoods == null && id != null) {
            pcSrcGoods = new PcSrcGoods();
            pcSrcGoods.setId(id);
            pcSrcGoods.settStatus(2);
            try {
                pcSrcGoods = dao.get(pcSrcGoods, "id", "tStatus");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getById,查询上线分类对应的商品失败:", e);
                return null;
            }
        }
        return pcSrcGoods;
    }

    @Override
    public List<PcSrcGoods> getParentId(Integer parentid) {
        List<PcSrcGoods> list = null;
        if ( parentid != null) {
            PcSrcGoods pcSrcGoods = new PcSrcGoods();
            pcSrcGoods = new PcSrcGoods();
            pcSrcGoods.setSrcId(parentid);
            pcSrcGoods.settStatus(2);
            try {
                list = dao.list(pcSrcGoods, "srcId", "tStatus");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getParentId,查询上线分类对应的商品失败:", e);
                return null;
            }
        }
        return  list;
    }
}
