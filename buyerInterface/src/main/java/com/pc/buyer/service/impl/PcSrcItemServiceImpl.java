package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcSrcItem;
import com.pc.buyer.service.PcSrcItemService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 分类项service处理
 * @date 2015/8/20
 */
@Service
public class PcSrcItemServiceImpl implements PcSrcItemService {
    @Autowired
    private BaseDaoImpl<PcSrcItem> dao;

    @Override
    public List<PcSrcItem> listAll() {
        List<PcSrcItem> list = null;
        PcSrcItem pcSrcItem = new PcSrcItem();
        pcSrcItem.setiStatus(2);
        try {
            list = dao.list(pcSrcItem, "iStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线分类项失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public PcSrcItem getById(Integer id) {
        PcSrcItem pcSrcItem = null;//CacheModel.getGoodsInfo(id);
        if (pcSrcItem == null && id != null) {
            pcSrcItem = new PcSrcItem();
            pcSrcItem.setId(id);
            pcSrcItem.setiStatus(2);
            try {
                pcSrcItem = dao.get(pcSrcItem, "id", "iStatus");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getById,查询上线分类项失败:", e);
                return null;
            }
        }
        return pcSrcItem;
    }

    @Override
    public PcSrcItem getByTypeId(Integer typeid) {
        PcSrcItem pcSrcItem = null;//CacheModel.getGoodsInfo(id);
        if (pcSrcItem == null && typeid != null) {
            pcSrcItem = new PcSrcItem();
            pcSrcItem.setTypeId(typeid);
            pcSrcItem.setiStatus(2);
            try {
                pcSrcItem = dao.get(pcSrcItem, "typeId", "iStatus");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getByTypeId,查询上线分类项失败:", e);
                return null;
            }
        }
        return pcSrcItem;
    }

}
