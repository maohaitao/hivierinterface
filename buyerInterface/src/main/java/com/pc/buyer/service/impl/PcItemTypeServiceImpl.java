package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcItemType;
import com.pc.buyer.service.PcItemTypeService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 分类列表service
 * @date 2015/8/21
 */
@Service
public class PcItemTypeServiceImpl implements PcItemTypeService {

    @Autowired
    private BaseDaoImpl<PcItemType> dao;

    @Override
    public List<PcItemType> listAll() {
        List<PcItemType> list = null;
        PcItemType pcItemType = new PcItemType();
        pcItemType.setiStatus(2);
        try {
            list = dao.list(pcItemType, "iStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线 PcItemType 失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public List<PcItemType> getParentId(Integer parentid) {
        List<PcItemType> list = null;
        if (parentid != null) {
            PcItemType pcItem = new PcItemType();
            pcItem.setiStatus(2);
            pcItem.setitemid(parentid);
            try {
                list = dao.list(pcItem, "iStatus","itemid");
            } catch (AppException e) {
                LogService.error("getParentId,查询所有上线 PcItemType 失败:", e);
                return null;
            }
        }
        return list;
    }
}
