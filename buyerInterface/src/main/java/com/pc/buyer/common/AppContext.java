package com.pc.buyer.common;


import com.sf.common.T;
import com.sf.common.reflection.property.PropertiesUtil;

/**
 * @author maohaitao
 * @ClassName: AppContext
 * @Des: 配置上下文
 */
public final class AppContext {
    // contronler返回数据类型
    public static final String PRODUCES = "application/json;charset=UTF-8";

    private AppContext() {

    }

    public static boolean IS_STARTED = true;


    // 系统短IP，如 1.32
    public static final String SYS_SHORT_IP = T.getShortLocalIpAddress();

    public static final String AICHAKUAIDI_URL = PropertiesUtil.getValue("aichakuaidi");

    public static final String SEARCH_ENGINE_IP = "10.0.0.16";
    public static final String SEARCH_ENGINE_PORT = "8983";
    public static final String SEARCH_ENGINE_CORE_SUGGEST = "suggest";
    public static final String SEARCH_ENGINE_CORE_COMMODITY = "commodity";
    public static final int SEARCH_ENGINE_DEFAULT_ROWS = 10;
    public static final int SEARCH_ENGINE_MAX_ROWS = 50;

    public static final String SEARCH_URL = PropertiesUtil.getValue("searchurl");

}
