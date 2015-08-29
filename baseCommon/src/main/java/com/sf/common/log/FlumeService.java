package com.sf.common.log;

import com.sf.common.AppContext;
import com.sf.common.T;
import com.sf.common.model.CommonRequest;
import com.sf.common.model.FlumeInfo;
import com.sf.common.model.FlumeRequest;
import com.sf.common.model.Phead;
import com.sf.common.util.DateUtil;
import com.sf.common.util.ServerUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FlumeService {

    private static final Map<String, FlumeInfo> flumeMap = new HashMap<String, FlumeInfo>();

    static {
        // 配置映射
        flumeMap.put("register", new FlumeInfo("reg", "注册"));
        flumeMap.put("login", new FlumeInfo("login", "登录"));
        flumeMap.put("refresh", new FlumeInfo("reflush", "刷新token"));
        flumeMap.put("bindopenid", new FlumeInfo("bindopenid", "绑定openid"));
        flumeMap.put("bindphone", new FlumeInfo("bindphone", "绑定手机号码"));
        flumeMap.put("bindephone", new FlumeInfo("bindphone", "绑定手机号码"));
        flumeMap.put("updateinfo", new FlumeInfo("updateinfo", "更新用户信息"));
        flumeMap.put("findpassword", new FlumeInfo("findpw", "更新密码"));
        flumeMap.put("updatepassword", new FlumeInfo("updatepw", "更新密码"));
        flumeMap.put("uploadportrait", new FlumeInfo("uploadportrait", "上传头像"));
    }

    public void flumeLog(FlumeRequest r) {
        flumeLog(r, null);
    }

    public void flumeLog(FlumeRequest r, String servletName) {
        if (r == null) {
            return;
        }

        try {
            Phead p = r.getPhead();
            if (p == null) {
                p = getPhead(r.getCommonRequest());
            }

            String userid = r.getUserid() > 0 ? r.getUserid() + "" : p.getUid();

            if (T.isBlank(r.getTarget())) {
                FlumeInfo flumeInfo = !T.isBlank(servletName) ? getFlumeInfo(servletName) : getFlumeInfo(r.getServletRequest());
                if (flumeInfo != null) {
                    r.setTarget(flumeInfo.getTarget());
                    r.setRemark(flumeInfo.getRemark());
                }
            }

            if (T.isBlank(r.getTarget())) {
                // 不在统计范围
                return;
            }

            FlumeLog.serviceStat(
                    101,
                    "0001||101||" + p.getAid() + "||" + p.getImei() + "||"
                            + DateUtil.formatDateToStringDefault(new Date()) + "||" + userid + "||" + AppContext.SYS_SHORT_IP
                            + "||" + p.getCip() + "||" + r.getType() + "||" + p.getCversionname() + "||" + p.getChannel()
                            + "||" + p.getLocal() + "||" + r.getTarget() + "||" + r.getOpResult() + "||" + r.getRemark() + "||");

        } catch (Exception e) {
            RsyncLog.error("flume log error!", e);
        }
    }

    private Phead getPhead(CommonRequest r) {
        if (r == null) {
            return new Phead();
        }

        try {
            Phead phead = ServerUtil.getRequestHead(r.getRequest());
            RsyncLog.debug("flume phead:" + phead);
            return phead;

        } catch (Exception e) {
            String recvlog = "[" + r.getRequest().getServletPath() + "] request:"
                    + ServerUtil.getRequestParameterString(r.getRequest()) + ";";
            RsyncLog.error("phead error!" + recvlog + " >>>>", e);
        }

        return new Phead();
    }

    private FlumeInfo getFlumeInfo(HttpServletRequest request) {
        String pathInfo = request.getServletPath();

        if (T.isBlank(pathInfo)) {
            return null;
        }

        if (pathInfo.startsWith("/")) {
            pathInfo = pathInfo.substring(1);
        }

        if (pathInfo.length() == 0) {
            return null;
        }

        return getFlumeInfo(pathInfo.toLowerCase());
    }

    private FlumeInfo getFlumeInfo(String key) {
        return flumeMap.containsKey(key) ? flumeMap.get(key) : null;
    }
}
