package test.com.seelles.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件位置
@ContextConfiguration({ "classpath:applicationContext-mybatis.xml", "classpath:springmvc.xml","classpath:applicationContext-service.xml" })
public class BaseControllerTest {
}
