package com.pc.user.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

/**
 * 描述：
 * 创建时间：15/8/20
 * 作者：yanghui
 */
@pbdb_alias("user_address")
public class UserAddress {
    @pbdb_ignore
    private Integer id;
    @pbdb_alias("user_id")
    private Integer userId;
    @pbdb_alias("receiver_name")
    private String receiverName;
    private String address;
    private String mobile;
    private String telephone;
    private String postCode;
    @pbdb_alias("is_defualt")
    private Integer isDefualt;

    public Integer getId() {
        return id;
    }

    public Integer getIsDefualt() {
        return isDefualt;
    }

    public void setIsDefualt(Integer isDefualt) {
        this.isDefualt = isDefualt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
