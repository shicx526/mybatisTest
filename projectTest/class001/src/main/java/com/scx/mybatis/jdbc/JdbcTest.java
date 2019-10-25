package com.scx.mybatis.jdbc;

import java.sql.*;

public class JdbcTest {
//    private static final String driver = "com.mysql.jdbc.Driver"; //数据库驱动
//    //连接数据库的URL地址
//    private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
//    private static final String username="root";//数据库的用户名
//    private static final String password="123456";//数据库的密码
    public static void main(String[] args) {

        //数据库的链接
        Connection connection = null;
        //预编译的statement，使用预编译的statement可以提高数据库性能（用statement操作数据库，通过statement向数据库发送语句，数据库需要编译，使用预编译的，数据库会将预编译结果存在数据库端缓存中，之后不会再编译相同sql）
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "123456");
            //定义sql语句 ?表示占位符
            String sql = "select * from user where username = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            //向数据库发出sql执行查询，查询出结果集
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源，倒叙释放
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

    }

}
