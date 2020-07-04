package com.seelles.mapper;

import com.seelles.pojo.Admin;
import com.seelles.pojo.User;

public interface AdminMapper {
    public Admin selectOne(String adname, String pwd);
}
