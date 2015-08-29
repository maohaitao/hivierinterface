package com.pc.buyer.cache;

import com.pc.buyer.model.PcBrandInfo;
import com.sf.common.log.LogService;
import com.sf.common.util.DateUtil;
import com.sf.common.util.JsonUtil;
import com.sf.redis.JedisCache;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.cache
 * @Des: redis处理
 * @date 2015/8/25
 */
public class RedisService {
    private static int expri = 1 * 24 * 60 * 60; // 默认有效期 7天
    public static JedisCache getJedisCache() {
        JedisCache cache = null;
        try {
            cache = new JedisCache();
        } catch (Exception e) {
            LogService.error("getJedisCache  error:", e);
        }
        return cache;
    }

    public static boolean set(String key, Object o, int expr) {
        if (expr <= 0) {
            expr = expri;
        }
        boolean flag = getJedisCache().setex(key, expr, JsonUtil.toJsonTree(o).toString());
        return flag;
    }

    public static Object get(String key, Class type) {
        Object resultobj = null;
        String re = getJedisCache().get(key);
        if (re != null) {
            if (type == null) {
                resultobj = JsonUtil.parseEle(re);
            } else {
                resultobj = JsonUtil.parse(re, type);
            }
        }
        return resultobj;
    }


    public static boolean hset(String key, String field, Object o) {
        long re = getJedisCache().hset(key, field, JsonUtil.toJsonTree(o).getAsString());
        return re > 0 ? true : false;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            PcBrandInfo brandInfo = new PcBrandInfo();
            brandInfo.setbStatus(1);
            brandInfo.setId(1);
            brandInfo.setCreateTime(DateUtil.getCurrentDate());
            List<PcBrandInfo> list = new ArrayList<>();
            list.add(brandInfo);
//            RedisService.getJedisCache().hset("test", i + "", JsonUtil.toJsonTree(brandInfo).toString());

            RedisCacheService service = new RedisCacheService();
            System.out.println(service.putHash(list,"test"));

        }

        System.out.println("end!");
    }
}
