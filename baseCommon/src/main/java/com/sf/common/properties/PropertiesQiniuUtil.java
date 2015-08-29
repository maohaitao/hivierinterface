package com.sf.common.properties;

import com.sf.common.log.RsyncLog;
import com.sf.common.reflection.Reflector;
import com.sf.common.util.CommonUtil;

import java.util.Date;
import java.util.Properties;

/**
 * @author hesin
 * @Created with： com.sf.common.properties
 * @Des: 七牛配置文件读取
 * @date 2015/8/26
 */
public class PropertiesQiniuUtil {
    private static final String CONFIG_DIR = "qiniu.properties";

    private static Properties properties = null;

    private PropertiesQiniuUtil() {
    }

    static {
        properties = PropertiesLoader.loadProperties(CONFIG_DIR);
    }

    /**
     * 得到系统业务配置参数
     *
     * @param key
     * @return 如果不存在，返回defaultValue
     */
    public static String getValue(String key, String defaultValue) {
        String value = getValue(key);
        return CommonUtil.isNull(value) ? defaultValue : value;
    }

    /**
     * 得到系统业务配置参数
     *
     * @param key
     * @return 如果不存在，返回defaultValue
     */
    public static int getValue(String key, int defaultValue) {
        String value = getValue(key);
        return CommonUtil.isNull(value) ? defaultValue : Integer.parseInt(value);
    }

    /**
     * 得到系统业务配置参数
     *
     * @param key
     * @return 如果不存在，返回null
     */
    public static String getValue(String key) {
        String value = properties.getProperty(key);

        if (value != null) {
            value = value.trim();
        }

        return value;
    }

    /**
     * @param configName 配置名
     * @param type       类型
     * @return
     * @Title getConfig
     * @Description 通过属性映射，把配置转换成实体
     */
    public static <T> T getConfig(String configName, Class<T> type) {
        Properties ps = PropertiesLoader.loadProperties(configName);
        Reflector reflector = Reflector.forClass(type);
        String[] propertyNames = reflector.getSetablePropertyNames();

        T t = null;
        try {
            t = type.newInstance();
        } catch (Exception e) {
            RsyncLog.error(e);
        }

        for (int i = 0; i < propertyNames.length; i++) {
            String propertyName = propertyNames[i];
            if (!ps.containsKey(propertyName)) {
                continue;
            }

            try {
                String value = ps.getProperty(propertyName);
                Class<?> propertyType = reflector.getSetterType(propertyName);

                if (value != null) {
                    value = value.trim();
                }

                Object v = null;

                if (propertyType == int.class) {
                    v = Integer.parseInt(value);
                } else if (propertyType == long.class) {
                    v = Long.parseLong(value);
                } else if (propertyType == String.class) {
                    v = value;
                } else if (propertyType == Date.class) {
                    v = new Date(Long.parseLong(value));
                } else if (propertyType == boolean.class) {
                    v = Boolean.parseBoolean(value);
                } else {
                    v = value;
                }

                reflector.getSetInvoker(propertyName).invoke(t, new Object[]{v});
            } catch (Exception e) {
                RsyncLog.error("getConfig error! type:" + type.getName(), e);
            }
        }

        return t;
    }
}
