package com.ssm.kernel.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssm.kernel.dao.UserMapper;
import com.ssm.kernel.model.User;
import com.ssm.kernel.service.IUserService;

/**
 * 
 * 使用spring注解方式缓存数据
 *
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    // 这里的value要跟ehcache.xml中保持一致，默认方式
    // @Cacheable(value = "userCache")

    // 将查询到的数据缓存到Cache中,并使用方法名称加上参数中的userNo作为缓存的key
    // 通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值
    @Cacheable(cacheNames = "ssmCache", key = "'get'+#userNo")
    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    @Override
    // 默认方式更新Cache
    // @CacheEvict(value = "userCache")

    // 根据设定的key，准确的清除特定的缓存，不会影响其它缓存值
    @CacheEvict(cacheNames = "ssmCache", key = "'get'+#userNo")
    public boolean updateUserById(int userId) {
        // TODO
        return true;
    }

    @Override
    // allEntries为true表示清除value中的全部缓存,默认为false
    @CacheEvict(cacheNames = "userCache", allEntries = true)
    public boolean removeUserById(int userId) {
        // TODO
        return true;
    }

}
