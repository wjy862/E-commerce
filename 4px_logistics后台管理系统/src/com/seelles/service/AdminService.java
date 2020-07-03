package com.seelles.service;

import com.seelles.pojo.Admin;
import com.seelles.pojo.User;
import com.seelles.util.ServerResponse;

public interface AdminService {
    public ServerResponse<Admin>  login(String adname, String pwd);


}
