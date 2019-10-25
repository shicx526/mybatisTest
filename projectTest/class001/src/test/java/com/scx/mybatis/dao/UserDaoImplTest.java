package com.scx.mybatis.dao;

import com.scx.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class UserDaoImplTest {

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
        //创建UserDao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //调用UserDao的方法
        User user = userDao.findUserById(2);

        System.out.println("user = " + user);
    }
}