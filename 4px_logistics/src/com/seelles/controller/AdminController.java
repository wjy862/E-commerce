package com.seelles.controller;

import com.seelles.pojo.Admin;
import com.seelles.service.AdminService;
import com.seelles.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/AdminController")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/loginAdmin")
    public String loginAdmin(String adname, String pwd, HttpServletRequest req, HttpSession session, HttpServletResponse resp){
        resp.setContentType("text/html;charset=utf-8");

        System.out.println("1");
        ServerResponse<Admin> admin=adminService.login(adname,pwd);

        if (admin.getData()!=null){
            System.out.println("2");
            session.setAttribute("admin",admin);
            System.out.println(session.getAttribute("admin"));
            return "forward:/index.jsp";
        }else{
            System.out.println("3");
            //req.setAttribute("msg","login fail");
            return "forward:/login.jsp";
        }
    }
}
