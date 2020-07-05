package test.com.seelles.controller; 

import com.seelles.pojo.Bon;

import com.seelles.service.BonService;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* BonController Tester. 
* 
* @author <Authors name> 
* @since <pre>7�� 4, 2020</pre> 
* @version 1.0 
*/ 
public class BonControllerTest extends BaseControllerTest{
    @Autowired
    private BonService bonService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: edit(int bid, HttpServletRequest req) 
* 
*/ 
@Test
public void testEdit() throws Exception { 
//TODO: Test goes here...
    System.out.println(bonService.findOne(1));
} 

/** 
* 
* Method: add(Bon bon, HttpServletRequest req) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    Bon bon=new Bon(1,"首次下单","全路线","运输");
    System.out.println(bonService.add(bon));
} 

/** 
* 
* Method: update(Bon bon, HttpServletRequest req) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    Bon bon=new Bon(1,"首次下单","全路线","运输");
    System.out.println(bonService.update(bon));
} 

/** 
* 
* Method: findAll(HttpServletRequest req) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    System.out.println(bonService.findAll());
} 

/** 
* 
* Method: findOne(int bid, HttpServletRequest req) 
* 
*/ 
@Test
public void testFindOne() throws Exception { 
//TODO: Test goes here...
    System.out.println(bonService.findOne(1));
} 

/** 
* 
* Method: delete(int bid, HttpServletRequest req) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
    System.out.println(bonService.delete(5));
} 

/** 
* 
* Method: rowCount() 
* 
*/ 
@Test
public void testRowCount() throws Exception { 
//TODO: Test goes here...
    System.out.println(bonService.rowCount());
} 


} 
