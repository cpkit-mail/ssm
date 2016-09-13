package com.ssm.kernel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.kernel.dao.UserMapper;
import com.ssm.kernel.model.User;
import com.ssm.kernel.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

}