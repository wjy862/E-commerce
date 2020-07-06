package com.seelles.controller;

import com.seelles.pojo.Adress;
import com.seelles.pojo.User;
import com.seelles.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/AdressController")
public class AdressController {

    @Autowired
    AdressService adressService;

    @RequestMapping("/edit")
    public String edit(int aid, HttpServletRequest req) throws Exception {
        //System.out.println("1");
        Adress adress=adressService.findOne(aid);
        //System.out.println("5");
        req.setAttribute("adress",adress);
        System.out.println(adress);
        return "forward:/adress-edit.jsp";
    }
    @RequestMapping("/add")
    public String add(Adress adress, HttpServletRequest req){
        int i =adressService.add(adress);

        //返回数据
        if(i>0){
            req.setAttribute("msg", "添加地址成功");
            return "redirect:/success.jsp";
        }else{
            req.setAttribute("msg", "添加地址失败");
            return "erro.jsp";
        }
    }
    @RequestMapping("/update")
    public String update(Adress adress, HttpServletRequest req){
        int i =adressService.update(adress);
        //返回数据
        if(i>0){
            req.setAttribute("msg", "更新员工成功");
            return "redirect:/success.jsp";
        }else{
            req.setAttribute("msg", "更新员工失败");
            return "redirect:/erro.jsp";
        }
    }


    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest req){
        List<Adress> adresses=adressService.findAll();

        //返回数据
        req.setAttribute("adresses",adresses);
        return "forward:/adress-list.jsp";
    }
    @RequestMapping("/findOne")
    public String findOne(int aid,HttpServletRequest req) {

        Adress adress=adressService.findOne(aid);

        req.setAttribute("adress",adress);

        return "forward:/adress-list.jsp";
    }

    @RequestMapping("/delete")
    public String delete(int aid,HttpServletRequest req){
        int i=adressService.delete(aid);

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
        int rowCount=adressService.rowCount();
        return rowCount;
    }
}
