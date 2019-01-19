package com.yorkmass.spring.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-generic-di.xml");
		UserService userService=(UserService)ctx.getBean("userService");
		userService.add();
		//UserService�̳�BaseService
		//UserRepository�̳�BaseRepository
		//UserService��UserRepository����ע��
		//BaseService��@Autowire�Զ�װ�䣬ע��BaseRepository<User>�������UserRepository
		
	}

}
