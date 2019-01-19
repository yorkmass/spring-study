package com.yorkmass.spring.aop.impl;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Spring��IOC����
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//��IOC�����л�ȡbean��ʵ��
		ArithmeticCalculator arithmeticCalculator=ctx.getBean(ArithmeticCalculator.class);
		//ʹ��bean
		arithmeticCalculator.add(3, 6);		
		arithmeticCalculator.div(12, 2);
		
	}

}
