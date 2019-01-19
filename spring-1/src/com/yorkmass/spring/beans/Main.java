package com.yorkmass.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//创建HelloWorld的一个对象
		HelloWorld helloworld=new HelloWorld();
		为name属性赋值
		helloworld.setName("test");
		*/
		//1.创建Spring的IOC容器对象
		//ApplicationContext代表IOC容器
		//ClassPathXmlApplicationContext:是ApplicationContext接口的实现类，该实现类从类路径下来加载配置文件
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取Bean实例
		//HelloWorld helloworld=(HelloWorld)ctx.getBean("helloworld");
		HelloWorld helloworld=ctx.getBean(HelloWorld.class);
		//当配置了两个bean,如果配置了两个class都是HelloWorld，就会出问题，所以这个方法要求bean里面的类唯一
		//利用类型返回IOC容器中的Bean，但要求IOC容器中必须只能有一个该类型的Bean
		//3.调用hello方法
		//helloworld.hello();
		
		Car car=(Car)ctx.getBean("car");
		System.out.println(car);
		car=(Car)ctx.getBean("car2");
		System.out.println(car);
		Person person=(Person)ctx.getBean("person2");
		System.out.println(person);
	}

}
