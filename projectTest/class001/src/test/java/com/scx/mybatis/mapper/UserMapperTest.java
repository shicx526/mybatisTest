package com.scx.mybatis.mapper;

import com.scx.mybatis.po.User;
import com.scx.mybatis.po.UserCustom;
import com.scx.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    //    此方法是在执行testFindUserById之前执行
    @Before
    public void setUp() throws Exception {
        //创建sqlSessionFactory
        //myBatis配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂,传入myBatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        userMapper.deleteUser(28);

//        System.out.println("user = " + user);
    }

//    @Test
//    public void findUserList() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象,mybatis自动生成mapper代理对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //创建包装对象
//        UserQueryVo userQueryVo = new UserQueryVo();
//        UserCustom userCustom = new UserCustom();
//        userCustom.setSex("1");
//        userCustom.setUsername("张三丰");
//        userQueryVo.setUserCustom(userCustom);
//        //调用userMapper的方法
//        List<UserCustom> userCustomList = userMapper.findUserList(userQueryVo);
//
//        System.out.println("userCustomList = " + userCustomList);
//    }
}