package com.ssm.kernel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.ssm.kernel.dao.UserMapper;
import com.ssm.kernel.model.User;
import com.ssm.kernel.service.IUserService2;

/**
 * 
 * 使用ehcache-spring-annotations注解方式缓存数据
 *
 */
@Service("userService2")
public class IUserServiceImpl2 implements IUserService2 {

    @Resource
    private UserMapper userMapper;

    @Override
    // 这里的cacheName要跟ehcache.xml中保持一致
    @Cacheable(cacheName = "ssmCache")
    public User getUserById2(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    @Override
    // 这里的cacheName要跟ehcache.xml中保持一致
    // 可移除缓存中的全部对象
    @TriggersRemove(cacheName = "ssmCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    public boolean updateUserById2(int userId) {
        // TODO
        return true;
    }

    @Override
    // 这里的cacheName要跟ehcache.xml中保持一致
    @TriggersRemove(cacheName = "ssmCache", removeAll = true)
    public boolean removeUserById2(int userId) {
        // TODO
        return true;
    }
}
