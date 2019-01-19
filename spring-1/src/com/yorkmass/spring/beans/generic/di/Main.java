package com.yorkmass.spring.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-generic-di.xml");
		UserService userService=(UserService)ctx.getBean("userService");
		userService.add();
		//UserService继承BaseService
		//UserRepository继承BaseRepository
		//UserService、UserRepository都被注解
		//BaseService被@Autowire自动装配，注入BaseRepository<User>子类对象UserRepository
		
	}

}
