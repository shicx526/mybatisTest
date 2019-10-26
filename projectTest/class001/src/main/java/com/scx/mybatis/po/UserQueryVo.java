package com.scx.mybatis.po;

import java.util.List;

//包装类型
public class UserQueryVo {
//    在这里包装所需要的查询条件
//    用户查询条件
    private UserCustom userCustom;

    private List<Integer> ids;
    private List<String> sexs;

    public List<String> getSexs() {
        return sexs;
    }

    public void setSexs(List<String> sexs) {
        this.sexs = sexs;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
    //    其他查询条件，订单、商品等
    //...
}
