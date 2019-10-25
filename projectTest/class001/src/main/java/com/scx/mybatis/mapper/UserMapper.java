package com.scx.mybatis.mapper;

import com.scx.mybatis.po.User;
import com.scx.mybatis.po.UserCustom;
import com.scx.mybatis.po.UserQueryVo;

import java.util.List;

//mapper接口，相当于dao接口
public interface UserMapper {
    //    用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //    根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //    添加用户信息
    public void insertUser(User user) throws Exception;

    //    删除用户信息
    public void deleteUser(int id) throws Exception;
}
