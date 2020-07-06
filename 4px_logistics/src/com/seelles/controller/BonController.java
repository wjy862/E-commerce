package com.seelles.controller;

import com.seelles.pojo.Bon;
import com.seelles.service.BonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/BonController")
public class BonController {

    @Autowired
    BonService bonService;

    @RequestMapping("/edit")
    public String edit(int bid, HttpServletRequest req) throws Exception {
        //System.out.println("1");
        Bon bon=bonService.findOne(bid);
        //System.out.println("5");
        req.setAttribute("bon",bon);
        System.out.println(bon);
        return "forward:/bon-edit.jsp";
    }
    @RequestMapping("/add")
    public String add(Bon bon, HttpServletRequest req){
        int i =bonService.add(bon);

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
    public String update(Bon bon, HttpServletRequest req){
        int i =bonService.update(bon);
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
        List<Bon> bons=bonService.findAll();

        //返回数据
        req.setAttribute("bons",bons);
        return "forward:/bon-list.jsp";
    }
    @RequestMapping("/findOne")
    public String findOne(int bid, HttpServletRequest req) {

        Bon bon=bonService.findOne(bid);

        req.setAttribute("bon",bon);

        return "forward:/bon-list.jsp";
    }

    @RequestMapping("/delete")
    public String delete(int bid,HttpServletRequest req){
        int i=bonService.delete(bid);

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
        int rowCount=bonService.rowCount();
        return rowCount;
    }
}
