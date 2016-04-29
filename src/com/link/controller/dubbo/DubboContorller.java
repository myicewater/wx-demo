package com.link.controller.dubbo;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class DubboContorller {

	private static final Logger logger = Logger.getLogger(DubboContorller.class);
	
	
	@ResponseBody
	@RequestMapping("/dubbo/test.htm")
	public Map dubboTest(){
		
		
		return null;
	}
}
