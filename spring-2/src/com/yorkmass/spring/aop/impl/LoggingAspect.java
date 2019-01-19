package com.yorkmass.spring.aop.impl;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//�����������Ϊһ������:��Ҫ�Ѹ�����뵽IOC�����У�������Ϊһ������
@Aspect
@Component
public class LoggingAspect {
	//�����÷�����һ��ǰ��֪ͨ:��Ŀ�귽����ʼ֮ǰִ��
	@Before("execution(public int com.yorkmass.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with"+args);
	}
	//����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣����ִ�е�֪ͨ
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("execution(* com.yorkmass.spring.aop.impl.*.*(int,int))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+"ends");
	}
	
}
