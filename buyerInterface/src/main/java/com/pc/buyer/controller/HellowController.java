package com.pc.buyer.controller; /**
 * Created by Administrator on 2015/8/4.
 */

import com.sf.common.log.LogService;
import com.sf.common.model.CommonRequest;
import com.sf.common.model.DynamicResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 */
@Controller
public class HellowController extends BaseController {

    @RequestMapping("/hellow.shtml")
    @ResponseBody
    public String hellow(HttpServletRequest request, HttpServletResponse response) {
        try {
            dealService(request, response);
        } catch (IOException e) {
            LogService.error("idget失败：", e);
        }
        return "";
    }


    @Override
    public DynamicResult handleBusiness(CommonRequest r) throws Exception {
        System.out.println("哈喽-------，Spring Boot ！");
        return null;
    }
}
