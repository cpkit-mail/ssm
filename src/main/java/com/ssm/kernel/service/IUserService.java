package com.ssm.kernel.service;

import com.ssm.kernel.model.User;

public interface IUserService {

    public User getUserById(int userId);

    public boolean updateUserById(int userId);

    public boolean removeUserById(int userId);

}