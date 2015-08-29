/**
 * @Title: Phead.java
 * @Package com.pb.model
 * @author maohaitao
 * @date 2015年4月2日 下午6:21:53
 * @version V1.0
 */
package com.sf.common.model;

import com.google.gson.Gson;

/**
 * @author maohaitao
 * @ClassName: Phead
 * @date 2015年4月2日 下午6:21:53
 */
public class Phead {
    private String pversion;// 协议版本号 默认1.0
    private String aid;// 手机androidid
    private int cid;// 产品id 默认 1
    private String cversion;// 客户端软件版本num
    private String cversionname = "";//
    private String uid;// 用户id内部ID
    private int channel;// 渠道号
    private String local = "";// 国家(大写)
    private String lang = "";// 语言（小写）
    private int sdk;// 系统sdklevel
    private String imsi;// 运营商编码
    private String imei;// imei
    private int official;// 是否为官方 默认：0，1：官方，2：非官方
    private String sys = "";// 系统版本
    private String rom;// 用户手机ROM信息
    private String phone = "";// 机型
    private String phonenum;// 手机号码
    private String dpi = "";// 手机分辨率 如320*480
    private String net;// 网络类型
    private int sbuy = 0;// 是否支持内购 0：不支持，1：支持
    private String appkey = "";// 应用key
    private String skey;// 密钥key
    private String googlepayid;// google play  ID
    private String cip;// 用户ip
    private String country;// 国家

    public Phead() {

    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public String getPversion() {
        return pversion;
    }

    public void setPversion(String pversion) {
        this.pversion = pversion;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCversion() {
        return cversion;
    }

    public void setCversion(String cversion) {
        this.cversion = cversion;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLang() {
        if (lang == null || lang.equals("")) {
            lang = "en";
        }
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getSdk() {
        return sdk;
    }

    public void setSdk(int sdk) {
        this.sdk = sdk;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public int getOfficial() {
        return official;
    }

    public void setOfficial(int official) {
        this.official = official;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getGooglepayid() {
        return googlepayid;
    }

    public void setGooglepayid(String googlepayid) {
        this.googlepayid = googlepayid;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public int getSbuy() {
        return sbuy;
    }

    public void setSbuy(int sbuy) {
        this.sbuy = sbuy;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }


    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCversionname() {
        return cversionname;
    }

    public void setCversionname(String cversionname) {
        this.cversionname = cversionname;
    }

    /**
     * @return 获取imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei
     * @Description 设置imei
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return 获取country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     * @Description 设置country
     */
    public void setCountry(String country) {
        this.country = country;
    }

}
