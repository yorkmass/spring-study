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
	 * 定义一个方法，用于声明切入点表达式，一般地，该方法中再不需要添入其他的代码
	 * 使用@Pointcut来声明切入点表达式
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式。不同类加类名.方法，不同包还要加包名.类名.方法
	 */
	@Pointcut("execution(public int com.yorkmass.spring.aop.ArithmeticCalculator.*(..))")
	public void declareJointPointExpression(){}
	/**
	 * 在com.yorkmass.spring.aop.ArithmeticCalculator 接口的每一个实现类的每一个方法开始之前执行一段代码
	 */
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		Object[] args=joinPoint.getArgs();
		System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
		
	}
	//在方法执行之后执行的代码，无论该方法是否出现异常
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with ");		
	}
	
	/**
	 * 在方法正常结束后执行的代码
	 * 返回通知是可以访问到方法的返回值的！
	 * @param joinPoint
	 */
	@AfterReturning(value="declareJointPointExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	/**
	 * 在方法出现异常时会执行的代码
	 * 可以访问到异常对象，且可以指定在出现特定异常时再执行通知代码
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
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数
	 * 环绕通知相当于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around("declareJointPointExpression()")
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
