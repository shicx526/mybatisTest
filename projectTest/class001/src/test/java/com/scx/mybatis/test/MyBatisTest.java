package com.scx.mybatis.test;

import com.scx.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyBatisTest {
    //根据id查询用户信息，返回一条结果
    @Test
    public void FindUserByIdTest() throws IOException {
//        myBatis配置文件
        String resource = "SqlMapConfig.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//创建会话工厂,传入myBatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过会话工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        通过SqlSession操作数据库
//        第一个参数：映射文件中的statement的id，等于=namespace+statement的id
//        第二个参数：指定和映射文件中所匹配的parameterType类型的参数
//        sqlSession.selectOne()结果是与映射文件中所匹配的resultType类型的对象
//        查询一条记录
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
//       释放资源
        sqlSession.close();

    }

    //根据id查询用户信息，返回一条结果
    @Test
    public void FindUserByNameTest() throws IOException {
//        myBatis配置文件
        String resource = "SqlMapConfig.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//创建会话工厂,传入myBatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过会话工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        查询多条
//        List中的User和映射文件中resultType所指定的类型一致
        List<User> list = sqlSession.selectList("test.findUserByName", "王");

        System.out.println(list);
//       释放资源
        sqlSession.close();

    }

    //添加用户信息
    @Test
    public void InsertUser() throws IOException, ParseException {
//        myBatis配置文件
        String resource = "SqlMapConfig.xml";
//        得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
//创建会话工厂,传入myBatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        通过会话工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        User user = new User();
        user.setUsername("汪东城");
        user.setBirthday(sdf.parse("2010-04-02"));
        user.setAddress("天上人间");
        user.setSex("1");
        sqlSession.insert("test.insertUser",user);

        //提交事务
        sqlSession.commit();

        //获取用户主键，自增主键返回

//       释放资源
        sqlSession.close();

    }

    //删除用户信息
    @Test
    public void deleteUser() throws IOException, ParseException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );

        sqlSession.delete("test.deleteUser",28);

        //提交事务
        sqlSession.commit();

        //获取用户主键，自增主键返回

//       释放资源
        sqlSession.close();

    }

    //更新用户信息
    @Test
    public void updateUser() throws IOException, ParseException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );

        User user = new User();
        user.setId(10);
        user.setUsername("王大军");
        user.setBirthday(sdf.parse("2006-04-02"));
        user.setAddress("苏州");
        user.setSex("1");

        sqlSession.delete("test.updateUser",user);

        //提交事务
        sqlSession.commit();

//       释放资源
        sqlSession.close();

    }
}
