package com.pc.user.module.userAddress.service;

import com.pc.user.model.UserAddress;
import com.sf.common.exception.AppException;
import com.sf.common.service.BaseService;
import com.sf.common.util.JsonUtil;
import com.sf.common.util.Result;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * 创建时间：15/8/20
 * 作者：yanghui
 */
@Service
public class UserAddressService extends BaseService {
    public static final Integer DEFUALT_YES = 1;

    public Result getDefaultAddress(Integer userId) {
        Result result = new Result();
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setIsDefualt(DEFUALT_YES);
        result.put("address", JsonUtil.toJsonTree(findByEntity(userAddress)));
        return result.success();
    }

    public Result search(Integer userId) throws AppException {
        Result result = new Result();
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        result.put("address", JsonUtil.toJsonTree(queryByEntity(userAddress)));
        return result.success();
    }


    public Result save(UserAddress userAddress) throws AppException {
        Result result = new Result();
        saveEntity(userAddress);
        return result.success();
    }
}
