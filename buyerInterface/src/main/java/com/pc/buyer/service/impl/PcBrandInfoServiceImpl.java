package com.pc.buyer.service.impl;

import com.pc.buyer.cache.RedisCacheService;
import com.pc.buyer.model.PcBrandInfo;
import com.pc.buyer.service.PcBrandInfoService;
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
 * @Des: 品牌的业务实现
 * @date 2015/8/18
 */
@Service
public class PcBrandInfoServiceImpl implements PcBrandInfoService {

    @Autowired
    BaseDaoImpl<PcBrandInfo> dao;
    private RedisCacheService redisCacheService = new RedisCacheService();

    @Override
    public List<PcBrandInfo> listAll() {
        List<PcBrandInfo> list = null;
        PcBrandInfo brand = new PcBrandInfo();
        brand.setbStatus(1);
        try {
            list = dao.list(brand, "bStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有正常合作品牌失败:", e);
            return null;
        }
        redisCacheService.putHash(list,RedisCacheService.BRAND_INFO_MAP_KEY);
        return list;
    }

    @Override
    public PcBrandInfo getById(Integer id) {
        PcBrandInfo b = null;//RedisCacheService.getBrand(id + "");
        if (b == null && id != null) {
            b = new PcBrandInfo();
            b.setId(id);
            b.setbStatus(1);
            try {
                b = dao.get(b, "id", "bStatus");
                redisCacheService.setHash(RedisCacheService.BRAND_INFO_MAP_KEY, id + "", b);
            } catch (AppException e) {
                LogService.error("getById,查询品牌失败:", e);
                return null;
            }
        }
        return b;

    }

    @Override
    public boolean listUpdate(Date time) {
        List<PcBrandInfo> list = null;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM pc_brand_info where b_status=? and update_time>=?";
            list = dao.list(sql, PcBrandInfo.class, 1, time);
        } catch (AppException e) {
            LogService.error("listUpdate,查询增量修改品牌信息失败:", e);
            return false;
        }
        if (list != null) {
            for (PcBrandInfo b : list) {
                redisCacheService.setHash(RedisCacheService.BRAND_INFO_MAP_KEY,b.getId()+"",b);
            }
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean listCancel(Date time) {
        List<PcBrandInfo> list = null;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM pc_brand_info where b_status=? and update_time>=?";
            list = dao.list(sql, PcBrandInfo.class, 2, time);
        } catch (AppException e) {
            LogService.error("listUpdate,查询增量修改品牌信息失败:", e);
            return false;
        }
        if (list != null) {
            for (PcBrandInfo info : list) {
                redisCacheService.rmHash(RedisCacheService.BRAND_INFO_MAP_KEY,info.getId()+"");
            }
            flag = true;
        }
        return flag;
    }
}
