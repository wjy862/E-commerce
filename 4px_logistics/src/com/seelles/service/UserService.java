package com.seelles.service;

import com.seelles.pojo.User;

import java.util.List;


public interface UserService {
    //login
    public User login(String telephone, String pwd);
    public int add(User user);
    public int update(User user);
    public List<User> findAll();
    public int delete(int uid);
}
