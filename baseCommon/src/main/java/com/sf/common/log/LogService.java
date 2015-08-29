/**
 * @Title: LogService.java
 * @Package com.pb.common.util
 * @author maohaitao
 * @date 2015年4月14日 下午2:09:23
 * @version V1.0
 */
package com.sf.common.log;


import com.sf.common.properties.PropertiesLoader;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.DateCoverd;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.LogLog;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

/**
 * @author maohaitao
 * @ClassName: LogService
 * @Des: 日志处理
 * @date 2015年4月14日 下午2:09:23
 */
public class LogService {
    private static final String LOGGER_FAIL = "failLogger";
    private static final String LOGGER_DEBUG = "debugLogger";
    private static final String LOGGER_INFO = "infoLogger";
    private static String project;
    private static String server;
    private static String logFilePath = null;
    private static final String FQCN = LogService.class.getName();

    public LogService() {

    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        URL resoucePath = PropertiesLoader.class.getClassLoader().getResource("log4j.properties");
        File file = new File(resoucePath.getPath());
        FileInputStream in = null;

        try {
            in = new FileInputStream(file);
            props.load(in);
        } catch (Exception var31) {
            LogLog.error(String.format("加载配置文件：%s失败！", new Object[]{file.getAbsolutePath()}), var31);
        } finally {
            try {
                in.close();
            } catch (Exception var28) {
                LogLog.error(String.format("关闭配置文件：%s输入流失败！", new Object[]{file.getAbsolutePath()}), var28);
            }

        }

        Properties props_stat = new Properties();
        resoucePath = PropertiesLoader.class.getClassLoader().getResource("flumelog.properties");
        if (resoucePath != null) {
            file = new File(resoucePath.getPath());

            try {
                in = new FileInputStream(file);
                props_stat.load(in);
            } catch (Exception var29) {
                LogLog.error(String.format("加载配置文件：%s失败！", new Object[]{file.getAbsolutePath()}), var29);
            } finally {
                try {
                    in.close();
                } catch (Exception var27) {
                    LogLog.error(String.format("关闭配置文件：%s输入流失败！", new Object[]{file.getAbsolutePath()}), var27);
                }

            }

            props.putAll(props_stat);
        }

        return props;
    }

    public static void error(String message) {
        Logger logger = Logger.getLogger("failLogger");
        logger.log(FQCN, Level.ERROR, message, (Throwable) null);
    }

    public static void error(Throwable e) {
        Logger logger = Logger.getLogger("failLogger");
        String logmessage = "message:" + e.getMessage() + " " + CommonUtil.getExceptionStackStr(e);
        logger.log(FQCN, Level.ERROR, logmessage, (Throwable) null);
    }

    public static void error(String message, Throwable e) {
        Logger logger = Logger.getLogger("failLogger");
        String logmessage = "message:" + message + " " + e.getMessage() + " " + CommonUtil.getExceptionStackStr(e);
        logger.log(FQCN, Level.ERROR, logmessage, (Throwable) null);
    }

    public static void debug(String message) {
        Logger logger = Logger.getLogger("debugLogger");
        logger.debug(message);
    }

    public static void debug(String message, Throwable e) {
        Logger logger = Logger.getLogger("debugLogger");
        String logmessage = "message:" + message + " " + CommonUtil.getExceptionStackStr(e);
        logger.debug(logmessage);
    }

    public static void info(String message) {
        Logger logger = Logger.getLogger("infoLogger");
        logger.info(message);
    }

    public static void info(String loggername, String message) {
        Logger logger = Logger.getLogger(loggername);
        logger.info(message);
    }

    public static void stat(String loggername, String message) {
        Logger logger = Logger.getLogger(loggername);
        logger.info(message);
    }

    public static void stat(String loggername, String separator, String... values) {
        Logger logger = Logger.getLogger(loggername);
        String logmessage = separator + CommonUtil.splitJointValue(separator, values);
        logger.info(logmessage);
    }

    protected static void flumeCollection(String loggername, String message) {
        message = CommonUtil.splitJointValue("#", new String[]{loggername, project, server, DateCoverd.toString(new Date()),
                message});
        message = message.replaceAll("\\s", " ");
        Logger logger = Logger.getLogger(loggername);
        logger.info(message);
    }

    public static String getLogFilePath() {
        return logFilePath;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; ++i) {
            flumeCollection("functionstat", "test");
        }

    }

    static {
        try {
            Properties e = loadProperties();
            project = e.getProperty("project");
            server = e.getProperty("server");
            if (CommonUtil.isNull(server)) {
                String serverip = CommonUtil.getLocalIP();
                String[] iptemps = serverip.split("\\.");
                server = iptemps[2] + "_" + iptemps[3];
                e.setProperty("server", server);
            }

            logFilePath = e.getProperty("logFilePath");
            PropertyConfigurator.configure(e);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
