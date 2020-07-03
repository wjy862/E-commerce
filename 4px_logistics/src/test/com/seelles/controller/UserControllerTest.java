package test.com.seelles.controller; 

import com.seelles.controller.UserController;
import com.seelles.pojo.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/** 
* UserController Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 2, 2020</pre> 
* @version 1.0 
*/ 
public class UserControllerTest { 

@Before
public void before() throws Exception {
    System.out.println("before");
} 

@After
public void after() throws Exception {
    System.out.println("after");
} 

/** 
* 
* Method: add(User user, MultipartFile fi, HttpSession session, HttpServletRequest req) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    UserController userController = new UserController();

} 

/** 
* 
* Method: login(String telephone, String pwd, HttpServletRequest req, HttpSession session) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fileUpload(String substring, MultipartFile fi, HttpServletRequest request) 
* 
*/ 
@Test
public void testFileUpload() throws Exception { 
//TODO: Test goes here... 
} 


} 
