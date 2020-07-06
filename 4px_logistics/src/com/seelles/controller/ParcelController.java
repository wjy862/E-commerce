package com.seelles.controller;

import com.seelles.pojo.Parcel;
import com.seelles.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ParcelController")
public class ParcelController {

    @Autowired
    ParcelService parcelService;

    @RequestMapping("/edit")
    public String edit(int pid, HttpServletRequest req) throws Exception {
        //System.out.println("1");
        Parcel parcel=parcelService.findOne(pid);
        //System.out.println("5");
        req.setAttribute("parcel",parcel);
        System.out.println(parcel);
        return "forward:/parcel-edit.jsp";
    }
    @RequestMapping("/add")
    public String add(Parcel parcel, HttpServletRequest req){
        int i =parcelService.add(parcel);

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
    public String update(Parcel parcel, HttpServletRequest req){
        int i =parcelService.update(parcel);
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
        List<Parcel> parcels=parcelService.findAll();

        //返回数据
        req.setAttribute("parcels",parcels);
        return "forward:/parcel-list.jsp";
    }
    @RequestMapping("/findOne")
    public String findOne(int pid, HttpServletRequest req) {

        Parcel parcel=parcelService.findOne(pid);

        req.setAttribute("parcel",parcel);

        return "forward:/parcel-list.jsp";
    }

    @RequestMapping("/delete")
    public String delete(int pid,HttpServletRequest req){
        int i=parcelService.delete(pid);

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
        int rowCount=parcelService.rowCount();
        return rowCount;
    }

}
