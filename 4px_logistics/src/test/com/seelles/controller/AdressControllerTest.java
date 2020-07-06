package test.com.seelles.controller; 



import com.seelles.pojo.Adress;
import com.seelles.pojo.User;
import com.seelles.service.AdressService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/** 
* AdressController Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 4, 2020</pre> 
* @version 1.0 
*/ 
public class AdressControllerTest extends BaseControllerTest{

    @Autowired
    private AdressService adressService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: edit(int aid, HttpServletRequest req) 
* 
*/ 
@Test
public void testEdit() throws Exception { 
//TODO: Test goes here...
    System.out.println(adressService.findOne(1));
} 

/** 
* 
* Method: add(Adress adress, HttpServletRequest req) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    Adress adress=new Adress(3,3,"cdscscs","dvdfdsf","25CSDC",2,null);

    System.out.println(adressService.add(adress));
} 

/** 
* 
* Method: update(Adress adress, HttpServletRequest req) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    Adress adress=new Adress(6,1000,3,"cx f","cdscscs","dvdfdsf",2,null);
    System.out.println(adressService.update(adress));
} 

/** 
* 
* Method: findAll(HttpServletRequest req) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here...
    System.out.println(adressService.findAll());
} 

/** 
* 
* Method: findOne(int aid, HttpServletRequest req) 
* 
*/ 
@Test
public void testFindOne() throws Exception { 
//TODO: Test goes here...
    System.out.println(adressService.findOne(1));
} 

/** 
* 
* Method: delete(int aid, HttpServletRequest req) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
    System.out.println(adressService.delete(5));
} 

/** 
* 
* Method: rowCount() 
* 
*/ 
@Test
public void testRowCount() throws Exception { 
//TODO: Test goes here...
    System.out.println(adressService.rowCount());
} 


} 
