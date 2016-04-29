package com.link.test.zcourse;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.link.model.activity.DrawAwardInfo;
import com.link.service.activity.ActivityService;
import com.link.test.base.AbstractBaseTest;


public class CoursesTest extends AbstractBaseTest{

	private static final Logger logger = Logger.getLogger(CoursesTest.class);  
	
	@Autowired
	private ActivityService activityService;
	
	
	@Test
	public void toCourseCenter(){
		
		String openId =  "aaa";
	      Map map = new HashMap();
	      
	      map.put("openId", openId);
	      
	      
	      DrawAwardInfo info = activityService.getHitAward(map);
	      logger.info("info"+info);
		
	}
}
