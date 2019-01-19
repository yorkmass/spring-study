package com.yorkmass.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator)ctx.getBean("arithmeticCalculator");
		int result=arithmeticCalculator.add(1, 5);
		System.out.println("result:"+result);
		result=arithmeticCalculator.div(1000, 20);
		System.out.println("result:"+result);
	}
	


}
