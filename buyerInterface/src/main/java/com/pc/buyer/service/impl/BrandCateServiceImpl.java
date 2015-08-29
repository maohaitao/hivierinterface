package com.pc.buyer.service.impl;

import com.pc.buyer.model.BrandCate;
import com.pc.buyer.service.BrandCateService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 品牌对应的分类信息
 * @date 2015/8/18
 */
@Service
public class BrandCateServiceImpl implements BrandCateService {
    @Autowired
    BaseDaoImpl<BrandCate> dao;

    @Override
    public List<BrandCate> listAll() {
        List<BrandCate> list = null;
        BrandCate cate = new BrandCate();
        cate.setcStatus(1);
        try {
            list = dao.list(cate, "cStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线品类失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public List<BrandCate> getById(String id) {
        BrandCate cateInfo = null;//CacheModel.getGoodsInfo(id);
        List<BrandCate> cateInfos = null;
        if (cateInfo == null) {
            cateInfo = new BrandCate();
            cateInfo.setcStatus(1);
            cateInfo.setCateId(Integer.parseInt(id));
            try {
                cateInfos = dao.list(cateInfo, "cStatus", "cateId");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getById,查询上线品类失败:", e);
                return null;
            }
        }
        return cateInfos;
    }

}
