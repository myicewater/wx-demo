package com.link.service.dubbo.demo;

public class HelloServiceImp implements HelloService {

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello"+name;
	}

}
