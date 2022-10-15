package com.wj.crowdfudding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wj
 * @create 2022-10-14 19:10
 */
// 指定 Spring 给 Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 Spring 配置文件的注解
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class testDruid {
    @Autowired
    private DataSource dataSource;
    @Test
    public void testDataSource() throws SQLException {
// 1.通过数据源对象获取数据源连接
        Connection connection = dataSource.getConnection();
// 2.打印数据库连接
        System.out.println(connection);
    }
}
