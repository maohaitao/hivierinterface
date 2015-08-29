package com.pc.buyer.business.impl;

import com.google.gson.*;
import com.pc.buyer.business.RemdInfoBusiness;
import com.pc.buyer.model.*;
import com.pc.buyer.service.*;
import com.sf.common.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.business.impl
 * @Des: 首页业务处理
 * @date 2015/8/21
 */
@Service
public class RemdInfoBusinessImpl implements RemdInfoBusiness {

    @Autowired
    private PcSrcItemService pcSrcItemService;

    @Autowired
    private PcSrcTypeService pcSrcTypeService;

    @Autowired
    private PcSrcGoodsService pcSrcGoodsService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Autowired
    private PcBannerInfoService pcBannerInfoService;

    @Autowired
    private PcItemItemService pcItemItemService;

    @Autowired
    private PcItemTypeService pcItemTypeService;

    @Override
    public JsonObject remdInfo(String typeid, String mark, Integer must) {
        JsonObject jsonObject = new JsonObject();
        PcSrcItem srcItem = null;
        if (typeid != null && CommonUtil.isNumber(typeid)) {
            srcItem = pcSrcItemService.getByTypeId(Integer.parseInt(typeid));
        }
        if (srcItem != null) {
            jsonObject = getChildSrcItem(srcItem, jsonObject);
        }
        return jsonObject;
    }

    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /**
     * 获取子节点数据
     *
     * @param srcItem
     * @return
     */
    public JsonObject getChildSrcItem(PcSrcItem srcItem, JsonObject jsonObject) {
        if (srcItem != null) {
            if (srcItem.getDatatype() == 1) { //对应分类项
                List<PcItemItem> list = childItem(srcItem.getId());
                childSrcItem(srcItem, jsonObject, list,srcItem.getTypeId());
            } else if (srcItem.getDatatype() == 2) { //对应分类列表
                List<PcSrcGoods> childType = childType(srcItem.getId());
                childSrcType(srcItem, jsonObject, childType);
            }
        }
        return jsonObject;
    }

    public void childSrcItem(PcSrcItem srcItem, JsonObject jsonObject) {
        if (srcItem != null) {
            if (srcItem.getDatatype() == 1) { //对应分类项
                List<PcItemItem> list = childItem(srcItem.getId());
                childSrcItem(srcItem, jsonObject, list,srcItem.getId());
            } else if (srcItem.getDatatype() == 2) { //对应分类列表
                List<PcSrcGoods> childType = childType(srcItem.getId());
                childSrcType(srcItem, jsonObject, childType);
            }
        }
    }

    public void childSrcItem(PcSrcItem srcItem, JsonObject jsonObject, List<PcItemItem> list,Integer id) {
        if (srcItem == null) {
            return;
        }
        JsonObject jsonElement = gson.toJsonTree(srcItem).getAsJsonObject();
        JsonArray array = new JsonArray();
        if (list != null && list.size() > 0) {
            for (PcItemItem itemItem : list) {
                if (itemItem != null) {
                    PcSrcItem item = pcSrcItemService.getById(itemItem.getchildid());
                    if (item != null) {
                        childSrcItem(item, jsonObject);
                        JsonObject json = new JsonObject();
                        json.addProperty("name", item.getTypeName());
                        json.addProperty("seq", 1);// TODO;
                        json.addProperty("pic", 2);// TODO;
                        json.addProperty("cicon", 2);// TODO;
                        json.addProperty("icon", item.getIcon());
                        json.addProperty("moreid", item.getMoreid() == 1 ? true : false);
                        json.addProperty("rid", item.getId());
                        json.addProperty("showtitle", item.getShowtitle() == 1 ? true : false);
                        json.addProperty("ishome", false); //TODO
                        json.addProperty("totalnum", 0); //TODO
                        array.add(json);
                    }
                }
            }
        }
        jsonElement.add("typedata", array);
        jsonObject.add(id!=null?id+"":srcItem.getId() + "", jsonElement); // TODO 对应key
    }

    public void childSrcType(PcSrcItem srcItem, JsonObject jsonObject, List<PcSrcGoods> list) {
        if (srcItem == null) {
            return;
        }
        JsonObject jsonElement = gson.toJsonTree(srcItem).getAsJsonObject();
        JsonArray array = new JsonArray();
        if (list != null && list.size() > 0) {
            for (PcSrcGoods itemItem : list) {
                if (itemItem != null) {
                    GoodsInfo item = goodsInfoService.getById(itemItem.getGoodsId());
                    if (item != null) {
//                        childSrcItem(srcItem, jsonObject);
                        JsonObject json = new JsonObject();
                        json.addProperty("name", item.getGoodsName());
                        json.addProperty("thumb", itemItem.getThumb());
                        json.addProperty("islike", 2);// TODO;
                        json.addProperty("icon", itemItem.getIcon());
                        json.addProperty("tagid", 1); //TODO
                        json.addProperty("price", item.getFinalPrice());
                        json.addProperty("brandname", "测试");//TODO
                        json.addProperty("rid", item.getId());
                        json.addProperty("desc", item.getDescription());
                        json.addProperty("acttype", itemItem.getActtype());
                        json.addProperty("actvalue", itemItem.getActvalue());
                        array.add(json);
                    }
                }
            }
        }
        jsonElement.add("resdata", array);
        jsonObject.add(srcItem.getId() + "", jsonElement);
    }

    /**
     * 获取子节点对应的分类项目
     *
     * @param itemid
     * @return
     */
    public List<PcItemItem> childItem(Integer itemid) {
        if (itemid == null) {
            return null;
        }
        List<PcItemItem> childItems = pcItemItemService.getParentId(itemid);
        return childItems;
    }

    public List<PcSrcGoods> childType(Integer itemid) {
        if (itemid == null) {
            return null;
        }
        List<PcSrcGoods> childType = pcSrcGoodsService.getParentId(itemid);
        return childType;
    }
}
