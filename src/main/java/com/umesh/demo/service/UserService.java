package com.umesh.demo.service;

import com.umesh.demo.entity.User;

import java.util.List;

public interface UserService {
    public boolean saveUser(User user);

    public List<User> fetchAllUser();
}
