package com.jason.yunNote;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DBUtil;

public class TestDB {

    private Logger logger = LoggerFactory.getLogger(TestDB.class);
    /*
    * 单元测试方法
    *1.方法返回值一般为void ，一般没有返回值
    * 2。参数列表，一般没有参数
    * 3。每个方法需要加上test注解，相当于独立的main函数
    * 4。每个方法都能独立运行
    * 5.方法为绿色表示测试成功
    * */
    @Test
    public void testDB(){

        System.out.println(DBUtil.getConnection());
        logger.info("获取数据库连接"+DBUtil.getConnection());

    }

}
