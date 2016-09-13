package com.ssm.kernel.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.kernel.model.User;
import com.ssm.kernel.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:conf/spring/beans-mybatis.xml" })
public class UserServiceTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private IUserService userService;

    @Test
    public void testGetUserById() {
        User user = userService.getUserById(1);
        logger.info("姓名：" + user.getUserName());
    }
}
