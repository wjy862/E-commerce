package com.seelles.controller;

import com.seelles.pojo.Admin;
import com.seelles.pojo.Adress;
import com.seelles.pojo.User;
import com.seelles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/UserController")
public class UserController {


    @Autowired
    UserService userService;

    public int rowCount(){
        int rowCount=userService.rowCount();
        return rowCount;
    }


    @RequestMapping("/delete")
    public String delete(int uid, HttpServletRequest req){
//处理数据
        //System.out.println(uid);
        int i=userService.delete(uid);

        //返回数据
        if(i>0){
            req.setAttribute("msg", "删除员工成功");

        }else{
            req.setAttribute("msg", "删除员工失败");
        }
        return "redirect:/UserController/findAll";
    }


    @RequestMapping("/findOne")
    public String findOne(int uid,HttpServletRequest req) {

        User users=userService.findOne(uid);

        req.setAttribute("users",users);

        return "forward:/member-list.jsp";
    }



    @RequestMapping("/findAll")
    public String findAll( HttpServletRequest req){
//处理数据
        List<User> users=userService.findAll();

        //返回数据
            req.setAttribute("users",users);
            return "forward:/member-list.jsp";

    }



 @RequestMapping("/update")
    public  String update (User user, MultipartFile fi, HttpServletRequest req) {

        //接受数据
     //如果有照片保存照片到update文件夹
     //System.out.println("1");
     if (fi!=null){
         //System.out.println("2");
         String substring = fi.getOriginalFilename().substring(fi.getOriginalFilename().lastIndexOf("."));
         /*****【F】判断文件的后缀******/
         if(!(".png".equals(substring)||".gif".equals(substring)||".jpg".equals(substring))){
             //System.out.println("3");
             req.setAttribute("msg","上传文件必须是图片");
             return  "/test.jsp";
         }else{
             try{
                 // System.out.println("4");
                 this.fileUpload(substring,fi,req);
             }catch (Exception e){
                 System.out.println("照片上传服务器失败");
                 e.printStackTrace();
             }
         }
     }
        user.setPhoto(fi.getOriginalFilename());
        //处理数据
        int i =userService.update(user);
        //返回数据
        if(i>0){
            req.setAttribute("msg", "更新员工成功");
            return "redirect:/success.jsp";
        }else{
            req.setAttribute("msg", "更新员工失败");
            return "redirect:/erro.jsp";
        }
    }

    @RequestMapping("/edit")
    public String edit(int uid,HttpServletRequest req) throws Exception {
        //System.out.println("1");
        User user=userService.findOne(uid);
        //System.out.println("5");
        req.setAttribute("user",user);

        return "forward:/member-edit.jsp";
    }

@RequestMapping("/add")
    public String add(User user, MultipartFile fi,HttpServletRequest req) throws Exception {
    //如果有照片保存照片到update文件夹
   System.out.println("1");
    if (fi!=null){
    System.out.println("2");
    String substring = fi.getOriginalFilename().substring(fi.getOriginalFilename().lastIndexOf("."));
    /*****【F】判断文件的后缀******/
    if(!(".png".equals(substring)||".gif".equals(substring)||".jpg".equals(substring))){
        System.out.println("3");
        req.setAttribute("msg","上传文件必须是图片1");
        return  "/test.jsp";
    }else{
        try{
            System.out.println("4");
            this.fileUpload(substring,fi,req);
        }catch (Exception e){
            System.out.println("照片上传服务器失败2");
            e.printStackTrace();
        }
    }
}

        //接受数据
        System.out.println("5");
        user.setPhoto(fi.getOriginalFilename());

        //处理数据
        int i =userService.add(user);

        //返回数据
        if(i>0){
            req.setAttribute("msg", "添加员工成功3");
            return "redirect:/success.jsp";
        }else{
            req.setAttribute("msg", "添加员工失败4");
            return "erro.jsp";
        }

    }

    @RequestMapping("/login")
    public String login(String telephone, String pwd, HttpServletRequest req, HttpSession session){

        User user=userService.login(telephone,pwd);

        if (user!=null){
            session.setAttribute("user",user);
            return "forward:/index.jsp";
        }else{
            req.setAttribute("msg","login fail");
            return "forward:/login.jsp";
        }
    }



    //文件的上传

    public  void  fileUpload(String substring,MultipartFile fi, HttpServletRequest request)throws  Exception{

        /****【E】限定上传文件的大小**/
       /* if(fi.getSize()>20*1024){

            request.setAttribute("msg","上传文件最大是20k");
            return "forward:/save.jsp";
        }*/

        /*****【D】相同图片名称覆盖****/
        String uuid = UUID.randomUUID().toString();

        // fl.jpg

        String  filename =uuid+substring;


        /****【C】获得服务器的目录******/

        String realPath = request.getServletContext().getRealPath("/upload");

        /**【B】自动创建文件目录**/
        File  file=new File(realPath);

        if(!file.exists()){

            file.mkdirs();
        }

        //文件上传完毕
        fi.transferTo(new File(file,filename));
    }

}
