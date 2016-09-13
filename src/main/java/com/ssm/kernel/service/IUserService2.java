package com.ssm.kernel.service;

import com.ssm.kernel.model.User;

public interface IUserService2 {

    public User getUserById2(int userId);

    public boolean updateUserById2(int userId);

    public boolean removeUserById2(int userId);

}