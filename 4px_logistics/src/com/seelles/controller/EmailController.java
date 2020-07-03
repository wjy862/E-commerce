package com.seelles.controller;

import com.seelles.pojo.Email;
import com.seelles.pojo.User;
import com.seelles.service.EmailService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/EmailController")
public class EmailController {
    @Autowired
    EmailService emailService;

    @RequestMapping("/showList")
    public String showList(HttpSession session, HttpServletRequest req){
       //get attribut
       User user= (User) session.getAttribute("user");
       //trait
       List<Email> list=emailService.showList(user.getUid());
       //response
        req.setAttribute("list",list);
       return "forward:/main.jsp";
    }
    @RequestMapping("/sendEmail")
    public String sendEmail(Email email, MultipartFile fi,HttpSession session, HttpServletRequest req) throws Exception {
        //get attribut
        User user= (User) session.getAttribute("user");
        email.setFilename(fi.getOriginalFilename());
        email.setEdate(new java.sql.Date(new Date().getTime()));
        email.setSendid(user.getUid());

    System.out.println(email);
        //trait
        int i =emailService.sendEmail(email);
        fi.transferTo(new File("D:/img/"+fi.getOriginalFilename()));

        //response
        if(i>0){
            return "redirect:/success.jsp";
        }else{
            return "emailSent.jsp";
        }
    }

    //文件下载操作

    @RequestMapping("fileDownLoad")
    public   void    fileDownLoad(String   filetype,String  filename, HttpServletRequest  req, HttpServletResponse resp) throws  Exception{

        //[1]把需要下载的文件从服务器读过来

        //获得需要下载的文件名称

        //获得服务器目录
        String realPath = req.getServletContext().getRealPath("/upload");

        File  file =new File(realPath+"/"+filename);

        InputStream inputStream =new FileInputStream(file);

        //设置属性下载到本地

        //设置下载文件的长度
        resp.setContentLength((int) file.length());

        //设置下载文件的类型
        resp.setContentType(filetype);

        //设置响应头信息
        resp.setHeader("Content-Disposition","attachment;filename="+filename);

        //[2]把读取的文件写到本地

        OutputStream outputStream =resp.getOutputStream();

        IOUtils.copy(inputStream,outputStream);


        outputStream.close();

        inputStream.close();
    }

}
/**
 *   遇到的问题：
 *
 *   1、上传图片的时候名字中文乱码：
 *   <property name="defaultEncoding" value="utf-8"></property>
 *
 *   2、上传的文件夹名称必须给出:
 *
 *   !file.exists()
 *
 *   3、上传不到当前服务器的路径中:
 *
 *   request.getServletContext().getRealPath("/upload");
 *
 *   4、相同的图片名称会覆盖:
 *
 *   UUID.randomUUID().toString()
 *
 *   5、无法指定上传图片的大小:
 *
 *   A、 fi.getSize()>20*1024
 *
 *   B、maxUploadSize--异常解析器
 *
 *   6、无法指定上传图片的类型: ok
 *
 *
 * */