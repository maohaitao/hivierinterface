package com.pc.buyer.task;

import com.pc.buyer.cache.RedisCacheService;
import com.pc.buyer.model.PcBrandInfo;
import com.pc.buyer.service.PcBrandInfoService;
import com.sf.common.log.LogService;
import com.sf.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.task
 * @Des: JVM缓存定时任务  TODO 缓存机制
 * @date 2015/8/21
 */

@Component
public class JVMCacheTask {

    @Autowired
    private PcBrandInfoService pcBrandInfoService;

    private Date time5m = null;
    private Date time1h = null;
    private RedisCacheService redisCacheService = new RedisCacheService();

    /**
     * * @return 格式: [秒] [分] [小时] [日] [月] [周] [年]
     * 序号 说明 是否必填 允许填写的值 允许的通配符
     * 1   秒    是      0-59 ,         - * /
     * 2    分    是      0-59 ,        - * /
     * 3    小时  是      0-23 ,       - * /
     * 4    日    是      1-31 ,      - * ? / L W
     * 5    月    是    1-12 or JAN-DEC , - * /
     * 6    周     是     1-7 or SUN-SAT , - * ? / L #
     * 7    年     否     empty 或 1970-2099 , - * /
     */
    @Scheduled(fixedDelay = 1000 * 60 * 60 * 1)   //每1小时执行一次全量
    public void initCache() {
        List<PcBrandInfo> list = pcBrandInfoService.listAll();
        boolean brandInitflag = redisCacheService.putHash(list, RedisCacheService.BRAND_INFO_MAP_KEY);
        LogService.info("初始化brand数据：brandInitflag=" + brandInitflag + "|");
        time1h = DateUtil.getCurrentDate();
    }

    @Scheduled(fixedDelay = 1000 * 60 * 5)   //每5分钟执行一次增量
    public void updateCache() {

    }

}
