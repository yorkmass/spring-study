package com.yorkmass.spring.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-beanfactory.xml");
		Car car=(Car)ctx.getBean("car");
		System.out.println(car);
		}

}
