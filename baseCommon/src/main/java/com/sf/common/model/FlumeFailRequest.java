/**
 * @Title: FlumeFailRequest.java
 * @Package com.pb.model
 * @author maohaitao
 * @date 2015年4月2日 下午6:26:40
 * @version V1.0
 */
package com.sf.common.model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maohaitao
 * @ClassName: FlumeFailRequest
 * @date 2015年4月2日 下午6:26:40
 */
public class FlumeFailRequest extends FlumeRequest {

    public FlumeFailRequest(CommonRequest commonRequest) {
        this(commonRequest, null);
    }

    public FlumeFailRequest(CommonRequest commonRequest, HttpServletRequest servletRequest) {
        super(commonRequest, servletRequest, "0");
    }

}
