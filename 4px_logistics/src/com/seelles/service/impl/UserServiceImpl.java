package com.seelles.service.impl;

import com.seelles.mapper.UserMapper;
import com.seelles.pojo.User;
import com.seelles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String telephone, String pwd) {
        return userMapper.selectOne(telephone,pwd);
    }

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public int delete(int uid) {
        return userMapper.delete(uid);
    }


}
