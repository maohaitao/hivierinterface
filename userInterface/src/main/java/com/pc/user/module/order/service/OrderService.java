package com.pc.user.module.order.service;

import com.sf.common.util.Result;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 描述：
 * 创建时间：15/8/19
 * 作者：yanghui
 */
@Service
public class OrderService {
    //查询购物车
    public Result orderConfirm(String shopCartIds) {
        Result result = new Result();
        Random random = new Random();
        result.put("total", random.nextInt(10000));
        return result.success();
    }
}
