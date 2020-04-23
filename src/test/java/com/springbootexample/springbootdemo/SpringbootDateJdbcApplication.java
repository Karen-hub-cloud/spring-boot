package com.springbootexample.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDateJdbcApplication {
    @Autowired
    DataSource dataSource;

    /*
    查看是否配置成功
     */
    @Test
    public void contextLoads() throws SQLException {
        System.out.println("查看数据源："+dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println("查看连接："+connection);
        connection.close();
    }
}
