package com.pc.buyer.model.from;

import com.google.gson.annotations.Expose;
import com.pc.buyer.model.GoodsDetails;
import com.pc.buyer.model.GoodsInfo;
import com.pc.buyer.model.PcBrandInfo;
import com.pc.buyer.model.PcBuyerInfo;

import java.util.List;
import java.util.Map;

/**
 * @author hesin
 * @Created with： com.pc.buyer.model.from
 * @Des: 商品的表单类
 * @date 2015/8/20
 */
public class GoodsInfoForm {

    @Expose
    private GoodsInfo bgsbinfo;// 商品详情信息
    @Expose
    private PcBuyerInfo buyer;
    @Expose
    private GoodsDetails goodsDetails;
    @Expose
    private PcBrandInfo pcBrandInfo;
    @Expose
    private  List<Map<String,Map<String,Object>>> colorsize;

//  private guesslike; 猜你喜欢


    public GoodsInfo getBgsbinfo() {
        return bgsbinfo;
    }

    public void setBgsbinfo(GoodsInfo bgsbinfo) {
        this.bgsbinfo = bgsbinfo;
    }

    public PcBuyerInfo getBuyer() {
        return buyer;
    }

    public void setBuyer(PcBuyerInfo buyer) {
        this.buyer = buyer;
    }

    public GoodsDetails getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(GoodsDetails goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public PcBrandInfo getPcBrandInfo() {
        return pcBrandInfo;
    }

    public void setPcBrandInfo(PcBrandInfo pcBrandInfo) {
        this.pcBrandInfo = pcBrandInfo;
    }

    public  List<Map<String,Map<String,Object>>> getColorsize() {
        return colorsize;
    }

    public void setColorsize( List<Map<String,Map<String,Object>>> colorsize) {
        this.colorsize = colorsize;
    }

    @Override
    public String toString() {
        return "GoodsInfoForm{" +
                "bgsbinfo=" + bgsbinfo +
                ", buyer=" + buyer +
                ", goodsDetails=" + goodsDetails +
                ", pcBrandInfo=" + pcBrandInfo +
                ", colorsize=" + colorsize +
                '}';
    }
}
