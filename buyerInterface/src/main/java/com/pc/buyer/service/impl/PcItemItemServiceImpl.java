package com.pc.buyer.service.impl;

import com.pc.buyer.model.PcItemItem;
import com.pc.buyer.model.PcSrcItem;
import com.pc.buyer.service.PcItemItemService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service.impl
 * @Des: 分类项业务处理
 * @date 2015/8/21
 */
@Service
public class PcItemItemServiceImpl implements PcItemItemService {

    @Autowired
    private BaseDaoImpl<PcItemItem> dao;

    @Override
    public List<PcItemItem> listAll() {
        List<PcItemItem> list = null;
        PcItemItem pcItem = new PcItemItem();
        pcItem.setiStatus(2);
        try {
            list = dao.list(pcItem, "iStatus");
        } catch (AppException e) {
            LogService.error("listAll,查询所有上线分类项对应关系失败:", e);
            return null;
        }
        return list;
    }

    @Override
    public List<PcItemItem> getParentId(Integer parentid) {
        List<PcItemItem> list = null;
        if (parentid != null) {
            PcItemItem pcItem = new PcItemItem();
            pcItem.setiStatus(2);
            pcItem.setparentid(parentid);
            try {
                list = dao.list(pcItem, "iStatus","parentid");
            } catch (AppException e) {
                LogService.error("getParentId,查询所有上线分类项对应的子类失败:", e);
                return null;
            }
        }
        return list;
    }

}
