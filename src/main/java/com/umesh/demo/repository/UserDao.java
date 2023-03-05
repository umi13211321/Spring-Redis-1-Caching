package com.umesh.demo.repository;


import com.umesh.demo.entity.User;

import java.util.List;

public interface UserDao {
    public boolean saveUser(User user);

    public List<User> fetchAllUser();
}
