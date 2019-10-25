package com.scx.mybatis.dao;

import com.scx.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.text.SimpleDateFormat;

public class UserDaoImpl implements UserDao {
//    //只是给时间和字符串转换用，和mybatis没关系
//    SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
    //    需要向dao实现类中注入SqlSessionFactory
//    这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        return user;
    }

    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
    }
}
