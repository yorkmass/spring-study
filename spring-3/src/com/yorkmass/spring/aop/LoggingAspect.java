package com.yorkmass.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	/**
	 * ����һ�����������������������ʽ��һ��أ��÷������ٲ���Ҫ���������Ĵ���
	 * ʹ��@Pointcut�������������ʽ
	 * ���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ����ͬ�������.��������ͬ����Ҫ�Ӱ���.����.����
	 */
	@Pointcut("execution(public int com.yorkmass.spring.aop.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){}
	/**
	 * ��com.yorkmass.spring.aop.ArithmeticCalculator �ӿڵ�ÿһ��ʵ�����ÿһ��������ʼ֮ǰִ��һ�δ���
	 */
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		Object[] args=joinPoint.getArgs();
		System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
		
	}
	//�ڷ���ִ��֮��ִ�еĴ��룬���۸÷����Ƿ�����쳣
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with ");		
	}
	
	/**
	 * �ڷ�������������ִ�еĴ���
	 * ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ�ģ�
	 * @param joinPoint
	 */
	@AfterReturning(value="declareJointPointExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	/**
	 * �ڷ��������쳣ʱ��ִ�еĴ���
	 * ���Է��ʵ��쳣�����ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJointPointExpression()",
			throwing="ex")
//	public void afterThrowing(JoinPoint joinPoint,Exception ex){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("The method "+methodName+" Throwing:"+ex);
//	}
	public void afterThrowing(JoinPoint joinPoint,NullPointerException ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" Throwing:"+ex);
	}
	
	/**
	 * ����֪ͨ��ҪЯ��ProceedingJoinPoint���͵Ĳ���
	 * ����֪ͨ�൱�ڶ�̬�����ȫ���̣�ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽����
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 */
	@Around("declareJointPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
	
		Object result=null;
		String methodName=pjd.getSignature().getName();
		
		//ִ��Ŀ�귽��
	try {
		//ǰ��֪ͨ
		System.out.println("The method "+methodName+" begin with: "+Arrays.asList(pjd.getArgs()));
		result=pjd.proceed();
		//����֪ͨ
		System.out.println("The method "+methodName+" end with:"+result);
		
	} catch (Throwable e) {
		// TODO: handle exception
		//�쳣֪ͨ
		System.out.println("The method "+methodName+" occurs exception:"+e);
		throw new RuntimeException(e);
	}
	//����֪ͨ
	System.out.println("The method "+methodName+" end with");
	return result;
	}
	
}
