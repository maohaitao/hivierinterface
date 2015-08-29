package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcSrcType;
import com.pc.buyer.service.PcSrcTypeService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 分类信息
 * @date 2015/8/20
 */
@Service
public class PcSrcTypeServiceImpl implements PcSrcTypeService {
    @Autowired
    BaseDaoImpl<PcSrcType> dao;

    @Override
    public List<PcSrcType> listAll() {
        List<PcSrcType> list = null;
        PcSrcType pcSrcType = new PcSrcType();
        pcSrcType.settStatus(2);
        try {
            list = dao.list(pcSrcType, "tStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线分类失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public PcSrcType getById(Integer id) {
        PcSrcType pcSrcType = null;//CacheModel.getGoodsInfo(id);
        if (pcSrcType == null && id != null) {
            pcSrcType = new PcSrcType();
            pcSrcType.setId(id);
            pcSrcType.settStatus(2);
            try {
                pcSrcType = dao.get(pcSrcType, "id", "tStatus");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getById,查询上线分类失败:", e);
                return null;
            }
        }
        return pcSrcType;
    }
}
