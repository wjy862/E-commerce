package test.com.seelles.controller; 

import com.seelles.controller.UserController;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* UserController Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 4, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件位置
@ContextConfiguration({ "classpath:applicationContext-mybatis.xml", "classpath:springmvc.xml","classpath:applicationContext-service.xml" })

public class UserControllerTest extends BaseControllerTest{

    @Autowired
    private UserController userController;

@Before
public void before() throws Exception {
    System.out.println("hello");
} 

@After
public void after() throws Exception {
    System.out.println("world");
} 

/** 
* 
* Method: rowCount() 
* 
*/

@Test
public void testRowCount() throws Exception { 
//TODO: Test goes here...
    System.out.println(userController.rowCount());
} 

/** 
* 
* Method: delete(int uid, HttpServletRequest req) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll(HttpServletRequest req) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(User user, MultipartFile fi, HttpServletRequest req) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: edit(int uid, HttpServletRequest req) 
* 
*/ 
@Test
public void testEdit() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: add(User user, MultipartFile fi, HttpServletRequest req) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
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
