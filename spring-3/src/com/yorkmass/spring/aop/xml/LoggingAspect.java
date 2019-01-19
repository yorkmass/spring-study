package com.yorkmass.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingAspect {



	
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		Object[] args=joinPoint.getArgs();
		System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
		
	}

	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with ");		
	}
	
	
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	
	public void afterThrowing(JoinPoint joinPoint,NullPointerException ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" Throwing:"+ex);
	}
	
	
	public Object aroundMethod(ProceedingJoinPoint pjd){
	
		Object result=null;
		String methodName=pjd.getSignature().getName();
		
		//执行目标方法
	try {
		//前置通知
		System.out.println("The method "+methodName+" begin with: "+Arrays.asList(pjd.getArgs()));
		result=pjd.proceed();
		//返回通知
		System.out.println("The method "+methodName+" end with:"+result);
		
	} catch (Throwable e) {
		// TODO: handle exception
		//异常通知
		System.out.println("The method "+methodName+" occurs exception:"+e);
		throw new RuntimeException(e);
	}
	//后置通知
	System.out.println("The method "+methodName+" end with");
	return result;
	}
	
}
