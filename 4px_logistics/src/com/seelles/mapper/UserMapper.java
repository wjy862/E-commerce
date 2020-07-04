package com.seelles.mapper;

import com.seelles.pojo.User;

import java.util.List;

public interface UserMapper {
    //search one line
    public User selectOne(String telephone, String pwd);

    public List<User> selectAll();

    public User findOne(int uid);

    public int insert(User user);

    public int delete(int uid);

    public int update(User user);

    public int rowCount();
}
