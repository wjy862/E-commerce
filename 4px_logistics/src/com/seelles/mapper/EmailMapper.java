package com.seelles.mapper;

import com.seelles.pojo.Email;

import java.util.List;

public interface EmailMapper {
    public List<Email> selectJoin(int uid);
    public int insert(Email email);
}
