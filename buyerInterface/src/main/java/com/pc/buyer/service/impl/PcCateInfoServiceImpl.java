package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcCateInfo;
import com.pc.buyer.service.PcCateInfoService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 品类信息
 * @date 2015/8/18
 */
@Service
public class PcCateInfoServiceImpl implements PcCateInfoService {

    @Autowired
    BaseDaoImpl<PcCateInfo> dao;

    @Override
    public List<PcCateInfo> listAll() {
        List<PcCateInfo> list = null;
        PcCateInfo cateInfo = new PcCateInfo();
        cateInfo.setcStatus(1);
        try {
            list = dao.list(cateInfo, "cStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线品类失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public PcCateInfo getById(String id) {
        PcCateInfo cateInfo = null;//CacheModel.getGoodsInfo(id);
        if (cateInfo == null) {
            cateInfo = new PcCateInfo();
            cateInfo.setcStatus(1);
            cateInfo.setId(Integer.parseInt(id));
            try {
                cateInfo = dao.get(cateInfo, "id", "cStatus");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getById,查询上线品类失败:", e);
                return null;
            }
        }
        return cateInfo;

    }
}
