package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcBannerInfo;
import com.pc.buyer.service.PcBannerInfoService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: banner/焦点的业务处理
 * @date 2015/8/19
 */
@Service
public class PcBannerInfoServiceImpl implements PcBannerInfoService {

    @Autowired
    private BaseDaoImpl<PcBannerInfo> dao;

    @Override
    public List<PcBannerInfo> listAll() {
        List<PcBannerInfo> list = null;
        PcBannerInfo bannerInfo = new PcBannerInfo();
        bannerInfo.setbStatus(3);
        try {
            list = dao.list(bannerInfo, "bStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线banner失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public PcBannerInfo getById(String id) {
        PcBannerInfo bannerInfo = null;//CacheModel.getGoodsInfo(id);
        if (bannerInfo == null) {
            bannerInfo = new PcBannerInfo();
            bannerInfo.setbStatus(3);
            bannerInfo.setId(Integer.parseInt(id));
            try {
                bannerInfo = dao.get(bannerInfo, "bStatus", "id");
//                CacheModel.setGoodsInfo(goodsInfo);
            } catch (AppException e) {
                LogService.error("getById,查询上线banner失败:", e);
                return null;
            }
        }
        return bannerInfo;
    }

}
