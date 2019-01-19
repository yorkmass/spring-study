package com.yorkmass.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//����HelloWorld��һ������
		HelloWorld helloworld=new HelloWorld();
		Ϊname���Ը�ֵ
		helloworld.setName("test");
		*/
		//1.����Spring��IOC��������
		//ApplicationContext����IOC����
		//ClassPathXmlApplicationContext:��ApplicationContext�ӿڵ�ʵ���࣬��ʵ�������·���������������ļ�
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.��IOC�����л�ȡBeanʵ��
		//HelloWorld helloworld=(HelloWorld)ctx.getBean("helloworld");
		HelloWorld helloworld=ctx.getBean(HelloWorld.class);
		//������������bean,�������������class����HelloWorld���ͻ�����⣬�����������Ҫ��bean�������Ψһ
		//�������ͷ���IOC�����е�Bean����Ҫ��IOC�����б���ֻ����һ�������͵�Bean
		//3.����hello����
		//helloworld.hello();
		
		Car car=(Car)ctx.getBean("car");
		System.out.println(car);
		car=(Car)ctx.getBean("car2");
		System.out.println(car);
		Person person=(Person)ctx.getBean("person2");
		System.out.println(person);
	}

}
