package com.seelles.controller;


import com.seelles.pojo.Command;
import com.seelles.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/CommandController")
public class CommandController {
    @Autowired
    CommandService commandService;

    @RequestMapping("/edit")
    public String edit(int cid, HttpServletRequest req) throws Exception {
        //System.out.println("1");
        Command command=commandService.findOne(cid);
        //System.out.println("5");
        req.setAttribute("command",command);
        System.out.println(command);
        return "forward:/command-edit.jsp";
    }
    @RequestMapping("/add")
    public String add(Command command, HttpServletRequest req){
        int i =commandService.add(command);

        //返回数据
        if(i>0){
            req.setAttribute("msg", "添加成功");
            return "redirect:/success.jsp";
        }else{
            req.setAttribute("msg", "添加失败");
            return "erro.jsp";
        }
    }
    @RequestMapping("/update")
    public String update(Command command, HttpServletRequest req){
        int i =commandService.update(command);
        //返回数据
        if(i>0){
            req.setAttribute("msg", "更新成功");
            return "redirect:/success.jsp";
        }else{
            req.setAttribute("msg", "更新失败");
            return "redirect:/erro.jsp";
        }
    }


    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest req){
        List<Command> commands=commandService.findAll();

        //返回数据
        req.setAttribute("commands",commands);
        return "forward:/command-list.jsp";
    }
    @RequestMapping("/findOne")
    public String findOne(int cid, HttpServletRequest req) {

        Command command=commandService.findOne(cid);

        req.setAttribute("command",command);

        return "forward:/command-list.jsp";
    }

    @RequestMapping("/delete")
    public String delete(int cid,HttpServletRequest req){
        int i=commandService.delete(cid);

        //返回数据
        if(i>0){
            req.setAttribute("msg", "删除地址成功");

        }else{
            req.setAttribute("msg", "删除地址失败");
        }
        return "redirect:/UserController/findAll";
    }

    @RequestMapping("/rowCount")
    public int rowCount() {
        int rowCount=commandService.rowCount();
        return rowCount;
    }
}
