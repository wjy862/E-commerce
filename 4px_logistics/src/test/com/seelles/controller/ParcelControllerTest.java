package test.com.seelles.controller; 


import com.seelles.pojo.Parcel;

import com.seelles.service.ParcelService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* ParcelController Tester. 
* 
* @author <Authors name> 
* @since <pre>7�� 4, 2020</pre> 
* @version 1.0 
*/ 
public class ParcelControllerTest extends BaseControllerTest{


    @Autowired
    private ParcelService parcelService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: edit(int pid, HttpServletRequest req) 
* 
*/ 
@Test
public void testEdit() throws Exception { 
//TODO: Test goes here... 
    System.out.println(parcelService.findOne(1));
} 

/** 
* 
* Method: add(Parcel parcel, HttpServletRequest req) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
    Parcel parcel=new Parcel(3,1,"首饰挂链",100.56,11,"首饰",null);

    System.out.println(parcelService.add(parcel));
} 

/** 
* 
* Method: update(Parcel parcel, HttpServletRequest req) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
    Parcel parcel=new Parcel(3,1,"首饰挂链",100.56,11,"首饰",null);
    System.out.println(parcelService.update(parcel));
} 

/** 
* 
* Method: findAll(HttpServletRequest req) 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
    System.out.println(parcelService.findAll());
} 

/** 
* 
* Method: findOne(int pid, HttpServletRequest req) 
* 
*/ 
@Test
public void testFindOne() throws Exception { 
//TODO: Test goes here... 
    System.out.println(parcelService.findOne(1));
} 

/** 
* 
* Method: delete(int pid, HttpServletRequest req) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
    System.out.println(parcelService.delete(5));
} 

/** 
* 
* Method: rowCount() 
* 
*/ 
@Test
public void testRowCount() throws Exception { 
//TODO: Test goes here... 
    System.out.println(parcelService.rowCount());
} 


} 
