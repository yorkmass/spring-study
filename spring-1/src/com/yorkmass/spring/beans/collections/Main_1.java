package com.yorkmass.spring.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person)ctx.getBean("person5");
		System.out.println(person);
		NewPerson newperson=(NewPerson)ctx.getBean("newPerson");
		System.out.println(newperson);
		DataSource datasource=ctx.getBean(DataSource.class);
		System.out.println(datasource);
	}

}
