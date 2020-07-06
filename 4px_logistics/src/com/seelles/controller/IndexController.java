package com.seelles.controller;

import com.seelles.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/IndexController")
public class IndexController {
    @RequestMapping("/index")
    public String index(String telephone, String pwd, HttpServletRequest req, HttpSession session){
            return "redirect:/index.jsp";
    }
}
