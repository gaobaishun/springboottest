package com.neo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class testClassTemplate {
    private String className;

    Logger logger= LoggerFactory.getLogger(testClassTemplate.class);
    @Before
    public void testBefore(){
        Class currentClass=this.getClass();
        className=currentClass.getSimpleName();
        logger.info("开始执行类："+className+"下的测试---------------");
    }

    @After
    public void testAfter(){
        logger.info("结束执行类："+className+"下的测试--------------");
    }
}
