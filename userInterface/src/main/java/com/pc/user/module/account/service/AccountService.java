package com.pc.user.module.account.service;

import com.sf.common.util.Result;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 描述：
 * 创建时间：15/8/19
 * 作者：yanghui
 */
@Service
public class AccountService {
    //查询购物车
    public Result login(String userName, String password) {

        Result result = new Result();
        result.put("Token",  UUID.randomUUID().toString());
        return result.success();
    }
}
