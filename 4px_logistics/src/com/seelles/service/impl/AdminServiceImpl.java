package com.seelles.service.impl;

import com.seelles.mapper.AdminMapper;
import com.seelles.pojo.Admin;
import com.seelles.service.AdminService;
import com.seelles.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public ServerResponse<Admin> login(String adname, String pwd) {
        Admin admin=adminMapper.selectOne(adname,pwd);
        if(admin!=null){
            return ServerResponse.createBySuccess("查询成功",admin);
        }else{
            return ServerResponse.createByError("查询记录为空");
        }
    }
}
