package com.yorkmass.spring.aop.impl;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建Spring的IOC容器
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//从IOC容器中获取bean的实例
		ArithmeticCalculator arithmeticCalculator=ctx.getBean(ArithmeticCalculator.class);
		//使用bean
		arithmeticCalculator.add(3, 6);		
		arithmeticCalculator.div(12, 2);
		
	}

}
