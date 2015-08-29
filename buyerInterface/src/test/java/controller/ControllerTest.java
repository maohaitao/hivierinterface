package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pc.buyer.annotation.RedisCache;
import com.sf.common.util.CommonUtil;

/**
 * Created by Administrator on 2015/4/15.
 */
public class ControllerTest {
    protected static String country = "sfda";
    protected static String lang = "zh"; //120.24.158.206:8082
    //        protected static String baseUrl = "http://192.168.1.229:8080/jiuyangshengong";//"http://127.0.0.1:8080";//  192.168.1.204
//    protected static String baseUrl = "http://192.168.1.204:20002/jiuyangshengongtest";//"http://127.0.0.1:8080";//  192.168.1.204
    protected static String baseUrl = "http://120.24.158.206:8082/jiuyangshengong";//"http://127.0.0.1:8080";//  192.168.1.204
    protected static String appkey = "golauncher";
    protected static String clientId = "picbuy";// "";
    protected static String clientSecret = "picbuy";// "b24eba390175f7ed";
    protected static String userid = "3894129";
    protected static String pwd = "123456";

    public static void main(String[] args) {
        boolean debug = true;
//        promo();
//        vip();
//        promocon();
//        promoPrd();
//        promoShop();

        idget();
//        queryLogisTest();
    }

//    @RedisCache(key = "test",method = "get")
    private static void idget() {
        JsonObject json = new JsonObject();
        json.addProperty("table_name", "order");// 18520129388
        json.addProperty("size", "10");

        json.addProperty("skuid", "JS40101552N3");// 18520129388
        json.addProperty("shopid", "3");
//        json.addProperty("userid", "order");// 18520129388
        json.addProperty("brandid", "1");
//        json.addProperty("vipids", "1");

        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_stockinfo_qurey.shtml", json); //  pb_orderid_get.shtml   pb_bandinfo_qurey    pb_stockinfo_qurey
    }

    private static void promoPrd() {
        JsonObject json = new JsonObject();

        json.addProperty("skuid", "JS40101552N3");// 18520129388
        json.addProperty("shopid", "5");
        json.addProperty("brandid", "1");
//        json.addProperty("vipids", "1");
        json.addProperty("sessionid", "sessionid1");

        JsonObject json1 = new JsonObject();
        json1.addProperty("skuid", "JS50803562N2");// 18520129388
        json1.addProperty("shopid", "5");
        json1.addProperty("brandid", "1");
        json1.addProperty("vipids", "1");
        json1.addProperty("sessionid", "sessionid1");

        JsonArray data = new JsonArray();
        data.add(json);
//        data.add(json1);
//        JsonObject object = new JsonObject();
//        object.addProperty("proid", "112");
//        object.add("data",data);
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);

        test("/query_promo_fromprd.shtml", data); //  pb_orderid_get.shtml   pb_bandinfo_qurey    pb_stockinfo_qurey
    }

    private static void promoShop() {
        JsonObject json = new JsonObject();

        json.addProperty("skuid", "JS40101552N1");// 18520129388
        json.addProperty("shopid", "5");
        json.addProperty("brandid", "1");
        json.addProperty("sessionid", "sessionid1");

        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/query_promo_fromshop.shtml", json); //  pb_orderid_get.shtml   pb_bandinfo_qurey    pb_stockinfo_qurey
    }

    private static void promo() {
        JsonObject json = new JsonObject();

        json.addProperty("skuid", "JS40101552N3");// 18520129388
        json.addProperty("shopid", "5");
        json.addProperty("shopname", "KK MALL");
        json.addProperty("brandid", "1");
        json.addProperty("vipids", "1");
        json.addProperty("skunum", "10");
        json.addProperty("sessionid", "sessionid1");

        JsonObject json1 = new JsonObject();

        json1.addProperty("skuid", "JS46002213N0");// 18520129388
        json1.addProperty("shopid", "5");
        json1.addProperty("shopname", "KK MALL");
        json1.addProperty("brandid", "1");
        json1.addProperty("vipids", "1");
        json1.addProperty("skunum", "5");
        json1.addProperty("sessionid", "sessionid1");

        JsonArray data = new JsonArray();
        data.add(json);
//        data.add(json1);
//        JsonObject object = new JsonObject();
//        JsonObject object = new JsonObject();
//        object.addProperty("proid", "1");
//        object.add("data",data);
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_promo_service.shtml", data); //  pb_orderid_get.shtml   pb_bandinfo_qurey    pb_stockinfo_qurey
    }

    private static void vip() {
        JsonObject json = new JsonObject();
        json.addProperty("skuid", "JS46002213N0");// 18520129388
        json.addProperty("shopid", "5");
        json.addProperty("shopname", "KK MALL");
        json.addProperty("vipids", "1");
        json.addProperty("brandid", "1");
        json.addProperty("skunum", "1");
        json.addProperty("sessionid", "sessionid1");

        JsonObject json1 = new JsonObject();
        json1.addProperty("vipcode", "15099994974");// 18520129388
        json1.addProperty("shopid", "5");
        json1.addProperty("shopname", "KK MALL");
        json1.addProperty("vipids", "1");
        json1.addProperty("brandid", "1");
        json1.addProperty("skunum", "1");
        json1.addProperty("sessionid", "sessionid1");

        JsonArray data = new JsonArray();
        data.add(json);
        data.add(json1);
//        JsonObject object = new JsonObject();
//        JsonObject object = new JsonObject();
//        object.addProperty("proid", "1");
//        object.add("data",data);
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_vippromotion.shtml", data); //  pb_orderid_get.shtml   pb_bandinfo_qurey    pb_stockinfo_qurey
    }

    private static void promocon() {
        JsonObject json = new JsonObject();
        json.addProperty("skuid", "JS40101552N1");// 18520129388
        json.addProperty("shopid", "5");
        json.addProperty("shopname", "test5");
        json.addProperty("brandid", "1");
        json.addProperty("vipids", "1");
        json.addProperty("skunum", "10");
        json.addProperty("sessionid", "sessionid1");

        JsonObject json1 = new JsonObject();
        json1.addProperty("skuid", "JS46002213N0");// 18520129388
        json1.addProperty("shopid", "5");
        json1.addProperty("shopname", "test5");
        json1.addProperty("brandid", "1");
//        json1.addProperty("vipids", "1");
        json1.addProperty("skunum", "5");
        json1.addProperty("sessionid", "sessionid1");

        JsonArray data = new JsonArray();
        data.add(json);
        System.out.println(data);
//        data.add(json1);
//        JsonObject object = new JsonObject();
//        JsonObject object = new JsonObject();
//        object.addProperty("proid", "1");
//        object.add("data",data);
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_promo_serviceCon.shtml", data); //  pb_orderid_get.shtml   pb_bandinfo_qurey    pb_stockinfo_qurey
    }

    private static void openidBindingTest() {
        JsonObject json = new JsonObject();
        json.addProperty("openid", "go1234");// 18520129388
        json.addProperty("type", "1");

        json.addProperty("nick_name", "test1hao");
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_user_openidbinding.shtml", json);
    }

    private static void queryUserInfoTest() {
        JsonObject json = new JsonObject();
        json.addProperty("openid", "go1234");// 18520129388
        json.addProperty("userid", "1");
        json.addProperty("nick_name", "test1hao");
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_user_userinfoqurey.shtml", json);
    }

    private static void queryLogisTest() {
        JsonObject json = new JsonObject();
        json.addProperty("order_num", "518053036");// 18520129388
        json.addProperty("logistics_num", "8587449058");
        json.addProperty("com", "1");
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("data", json);
        test("/pb_logistics_transportquery.shtml", json);
    }

    protected static void test(String serverUrl, JsonElement customFormData) {
        try {
//            FormData formdata = new FormData();// 文件解压
//            String handle = "1";
//            formdata.addParam("shandle", "1");
//            formdata.addParam("handle", handle); // CommonUtil.gzip
//            formdata.addParam("client_id", clientId);
//            formdata.addParam("client_secret", clientSecret);
//            PostData postData = new PostData(formdata);
//            String url = baseUrl + serverUrl;
//            System.out.println("url=" + url);
//
//            JsonObject phead = new JsonObject();
//            phead.addProperty("client_id", clientId);
//            phead.addProperty("client_secret", clientSecret);
//            phead.addProperty("hasmarket", 1);
//            phead.addProperty("androidid", "21fce9a3a577792a");
//            phead.addProperty("launcherid", "5173704541520287230");
//            phead.addProperty("sys", "testmo");
//            phead.addProperty("dpi", "480*1285");
//            phead.addProperty("sdk", 10);
//            phead.addProperty("local", "CN");
//            phead.addProperty("channel", "253");
//            phead.addProperty("lang", "zh_CN");
//            phead.addProperty("sdk", 15);
//            phead.addProperty("pversion", "4.8");
//            phead.addProperty("imsi", "45123123");
//            phead.addProperty("cversion", "3.6bata");
//            phead.addProperty("clientid", "26");
//
//            JsonObject data = new JsonObject();
//            data.add("phead", phead); // 消息头
//            data.add("data", customFormData); // 消息体
//            if (handle == "1") {
//                formdata.addParam("data", new String(CommonUtil.gzip(data.toString().getBytes("UTF-8")), "ISO-8859-1")); // 消息
//            } else {
//                formdata.addParam("data", data.toString()); // 消息
//            }
//            postData = new PostData(formdata);
//            System.out.println("------" + data.toString());
//            HttpResult httpResult = HttpClientUtil.post(url, postData);
//            String responsedata = unCompressData(httpResult.getData());
//            System.out.println(serverUrl + " res:" + responsedata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static String unCompressData(byte[] bytes) throws Exception {
        try {
            byte[] new_bytes = CommonUtil.ungzip(bytes);
            bytes = null;
            String data = new String(new_bytes, "UTF-8");
            new_bytes = null;
            return data;
        } catch (Exception ex) {
            return new String(bytes, "UTF-8");
        }
    }

}
