package com.yorkmass.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) 
			throws BeansException {
			System.out.println("postProcessAfterInitialization..."+bean+","+beanName);
			Car car=new Car();
			car.setBrand("Ford");
			return car;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) 
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeforeInitialization..."+bean+","+beanName);
		if("car".equals(beanName)){
			//...处理指定的bean
		}
		return bean;
	}

}
