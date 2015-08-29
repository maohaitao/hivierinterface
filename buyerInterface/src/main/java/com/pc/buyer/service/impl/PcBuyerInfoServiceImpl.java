package com.pc.buyer.service.impl;

import com.pc.buyer.cache.RedisCacheService;
import com.pc.buyer.model.PcBuyerInfo;
import com.pc.buyer.service.PcBuyerInfoService;
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
 * @Des: 买手信息service
 * @date 2015/8/18
 */
@Service
public class PcBuyerInfoServiceImpl implements PcBuyerInfoService {

    @Autowired
    BaseDaoImpl<PcBuyerInfo> dao;

    @Override
    public List<PcBuyerInfo> listAll() {
        List<PcBuyerInfo> list = null;
        PcBuyerInfo buyerInfo = new PcBuyerInfo();
        buyerInfo.setbStatus(3);
        try {
            list = dao.list(buyerInfo, "bStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有审核通过的商家失败:", e);
            return null;
        }
        return list;
    }

    RedisCacheService redisCacheService = new RedisCacheService<PcBuyerInfo>();

    @Override
    public PcBuyerInfo getById(Integer id) {
        PcBuyerInfo buyerInfo = (PcBuyerInfo) redisCacheService.get(RedisCacheService.BUYER_INFO_KEY,id + "", PcBuyerInfo.class);
        if (buyerInfo == null && id != null) {
            buyerInfo = new PcBuyerInfo();
            buyerInfo.setId(id);
            buyerInfo.setbStatus(3);
            try {
                buyerInfo = dao.get(buyerInfo, "id", "bStatus");
                redisCacheService.set(buyerInfo,buyerInfo.getId()+"",0);
            } catch (AppException e) {
                LogService.error("getById,查询上线买手失败:", e);
                return null;
            }
        }
        return buyerInfo;

    }

    @Override
    public boolean listUpdate(Date time) {
        List<PcBuyerInfo> list = null;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM pc_buyer_info where b_status=? and update_time>=?";
            list = dao.list(sql, PcBuyerInfo.class, 4, time);
        } catch (AppException e) {
            LogService.error("listUpdate,查询增量审核通过买手失败:", e);
            return false;
        }
        if (list != null) {
            for (PcBuyerInfo info : list) {
                redisCacheService.set(info, info.getId() + "", 0);
            }
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean listCancel(Date time) {
        List<PcBuyerInfo> list = null;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM pc_buyer_info where b_status=? and update_time>=?";
            list = dao.list(sql, PcBuyerInfo.class, 5, time);
        } catch (AppException e) {
            LogService.error("listUpdate,查询增量进入黑名单的买手信息失败:", e);
            return false;
        }
        if (list != null) {
            for (PcBuyerInfo info : list) {
                redisCacheService.set(info,info.getId()+"",0);
            }
            flag = true;
        }
        return flag;
    }
}
