package test.com.seelles.controller; 

import com.seelles.pojo.Command;

import com.seelles.service.CommandService;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* CommandController Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 4, 2020</pre> 
* @version 1.0 
*/ 
public class CommandControllerTest extends BaseControllerTest{
    @Autowired
    private CommandService commandService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: edit(int cid, HttpServletRequest req) 
* 
*/ 
@Test
public void testEdit() throws Exception { 
//TODO: Test goes here... 
    System.out.println(commandService.findOne(1));
} 

/** 
* 
* Method: add(Command command, HttpServletRequest req) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
    sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
    Date date = new Date();// 获取当前时间
    System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
    String time=sdf.format(date);
    Command command=new Command(3,1,1.5,1.6,1.1,1.2,1.3,1.4,10225,null,"kjkjcdscscs","dvdfdsf","25CSjkDC","cdsjkcscs","dvftdfdsf","jiuede",time);

    System.out.println(commandService.add(command));
} 

/** 
* 
* Method: update(Command command, HttpServletRequest req) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
    sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
    Date date = new Date();// 获取当前时间
    System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
    String time=sdf.format(date);
    Command command=new Command(3,4,3,2.00,1.6,1.1,1.2,1.3,1.4,10225,null,"cdscscs","dvdfdsf","25CSDC","cdscscs","dvdfdsf","25CSDC",time);

    System.out.println(commandService.update(command));
} 

/** 
* 
* Method: findAll(HttpServletRequest req) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
    System.out.println(commandService.findAll());
} 

/** 
* 
* Method: findOne(int aid, HttpServletRequest req) 
* 
*/ 
@Test
public void testFindOne() throws Exception { 
//TODO: Test goes here... 
    System.out.println(commandService.findOne(1));
} 

/** 
* 
* Method: delete(int aid, HttpServletRequest req) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
    System.out.println(commandService.delete(5));
} 

/** 
* 
* Method: rowCount() 
* 
*/ 
@Test
public void testRowCount() throws Exception { 
//TODO: Test goes here... 
    System.out.println(commandService.rowCount());
} 


} 
