package com.sf.common.log;

import com.sf.common.exception.AppException;
import com.sf.common.exception.ExceptionType;
import com.sf.common.model.FunStatBean;
import com.sf.common.util.CommonUtil;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author hesin
 * @Created with： com.sf.common.log
 * @date 2015/8/13
 */
public class FlumeLog {
    private static final String LOGGER_FUNCTIONSTAT = "functionstat";
    private static final String LOGGER_SERVICESTAT = "servicestat";
    private static final String LOGGER_EXCEPTIONSTAT = "exceptionstat";
    private static final String LOGGER_STATFILELOG = "statfilelog";
    private static boolean resendtask = false;

    public FlumeLog() {
    }

    public static void functionStat(FunStatBean funStatBean) {
        byte issuccess_int = 0;
        if (funStatBean.issuccess) {
            issuccess_int = 1;
        }

        String message = CommonUtil.splitJointValue("#", new String[]{funStatBean.funckey, issuccess_int + "", funStatBean.restime + "", funStatBean.flowsize + "", funStatBean.clientid, funStatBean.cversion, funStatBean.uid, funStatBean.androidid, funStatBean.channel, funStatBean.local, funStatBean.sdklevl, funStatBean.imsi});
        LogService.flumeCollection("functionstat", message);
    }

    public static void functionStat(String funckey, boolean issuccess, int restime, int flowsize, String clientid, String cversion, String uid, String androidid, String channel, String local, String sdklevl, String imsi) {
        byte issuccess_int = 0;
        if (issuccess) {
            issuccess_int = 1;
        }

        String message = CommonUtil.splitJointValue("#", new String[]{funckey, issuccess_int + "", restime + "", flowsize + "", clientid, cversion, uid, androidid, channel, local, sdklevl, imsi});
        LogService.flumeCollection("functionstat", message);
    }

    public static void serviceStat(int protocolid, String statinfo) {
        String message = CommonUtil.splitJointValue("#", new String[]{protocolid + "", statinfo});
        LogService.flumeCollection("statfilelog", message);
        LogService.flumeCollection("servicestat", message);
    }

    public static void exceptionStat(ExceptionType exceptionType, Throwable e, String... params) {
        String ekey = e.getClass().getName();
        if (e instanceof AppException) {
            ekey = ekey + ";" + e.getMessage();
        }

        ekey = ekey.replace("#", "_");
        String einfo = e.getMessage() + "; " + CommonUtil.getExceptionStackStr(e);
        einfo = einfo.replace("#", "_");
        String paramsinfo = CommonUtil.splitJointValue(",", params);
        paramsinfo = paramsinfo.replace("#", "_");
        String message = CommonUtil.splitJointValue("#", new String[]{exceptionType.getTypename(), ekey, einfo, paramsinfo});
        LogService.error(message);
        LogService.flumeCollection("exceptionstat", message);
    }

    public static void exceptionStat(ExceptionType exceptionType, String emessage, String estack, String... params) {
        emessage = emessage.replace("#", "_");
        estack = estack.replace("#", "_");
        String paramsinfo = CommonUtil.splitJointValue(",", params);
        paramsinfo = paramsinfo.replace("#", "_");
        String message = CommonUtil.splitJointValue("#", new String[]{exceptionType.getTypename(), emessage, estack, paramsinfo});
        LogService.error(message);
        LogService.flumeCollection("exceptionstat", message);
    }

    public static void resendFlumeFailLog(String dirpath, String pattern) {
        if (CommonUtil.isNull(dirpath)) {
            dirpath = LogService.getLogFilePath() + "/log/flumefaillog/";
        }

        File dir = new File(dirpath);
        if (!dir.exists()) {
            LogService.error("FlumeLog.resendFlumeFailLog faild:dirpath " + dirpath + " not exists!");
        } else {
            File[] arr$ = dir.listFiles();
            int len$ = arr$.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                File failfile = arr$[i$];
                if (failfile.exists()) {
                    String filename = failfile.getName();
                    if ((CommonUtil.isNull(pattern) || filename.contains(pattern)) && filename.contains("flumefilelog_") && filename.contains(".")) {
                        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
                        if (suffix.length() >= 10) {
                            FileReader fr = null;
                            BufferedReader br = null;

                            try {
                                fr = new FileReader(failfile);
                                br = new BufferedReader(fr);
                                String e = br.readLine();

                                while (e != null) {
                                    try {
                                        String e1 = null;
                                        if (e.startsWith("functionstat")) {
                                            e1 = "functionstat";
                                        } else if (e.startsWith("servicestat")) {
                                            e1 = "servicestat";
                                        } else if (e.startsWith("exceptionstat")) {
                                            e1 = "exceptionstat";
                                        }

                                        if (e1 != null) {
                                            Logger logger = Logger.getLogger(e1);
                                            logger.info(e);
                                        }
                                    } catch (Exception var29) {
                                        LogService.error("FlumeLog.resendFlumeFailLog faild", var29);
                                    }

                                    try {
                                        e = br.readLine();
                                    } catch (Exception var28) {
                                        LogService.error("FlumeLog.resendFlumeFailLog faild", var28);
                                        e = null;
                                    }
                                }

                                failfile.delete();
                                LogService.debug("FlumeLog.resendFlumeFailLog " + filename);
                            } catch (Exception var30) {
                                LogService.error("FlumeLog.resendFlumeFailLog faild", var30);
                            } finally {
                                if (br != null) {
                                    try {
                                        br.close();
                                    } catch (IOException var27) {
                                        ;
                                    }
                                }

                                if (fr != null) {
                                    try {
                                        fr.close();
                                    } catch (IOException var26) {
                                        ;
                                    }
                                }

                            }
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        LogService.info("flumefilelog", "functionstat#webapp#214_4#2013-04-09 11:49:47#test");
        resendFlumeFailLog((String) null, (String) null);
        LogService.info("flumefilelog", "functionstat#webapp#214_4#2013-04-09 11:49:47#test");
    }

    static {
        if (!resendtask) {
            (new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(600000L);
                            FlumeLog.resendFlumeFailLog((String) null, (String) null);
                        } catch (Exception var2) {
                            LogService.error("FlumeLog.resendFlumeFailLog faild", var2);
                        }
                    }
                }
            })).start();
            resendtask = true;
        }

    }
}

