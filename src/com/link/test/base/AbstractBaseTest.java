package com.link.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4    
@ContextConfiguration({"classpath:spring-*.xml"}) //指定Spring的配置文件 /为classpath下    
//@Transactional //对所有的测试方法都使用事务，并在测试完成后回滚事务    
public class AbstractBaseTest {

	
}
