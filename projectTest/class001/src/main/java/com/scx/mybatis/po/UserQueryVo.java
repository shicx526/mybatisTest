package com.scx.mybatis.po;

//包装类型
public class UserQueryVo {
//    在这里包装所需要的查询条件
//    用户查询条件
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
    //    其他查询条件，订单、商品等
    //...
}
