package com.yorkmass.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * ����ʹ��@Orderע��ָ����������ȼ���ֵԽС���ȼ�Խ��
 * @author Administrator
 *
 */
@Order(1)
@Aspect
@Component
public class VlidationAspect {
	//��ͬ���»�Ҫ�Ӱ�����com.yorkmass.spring.aop.LoggingAspect.declareJointPointExpression()
	@Before("LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("-->validate"+Arrays.asList(joinPoint.getArgs()));
		
	}

}
