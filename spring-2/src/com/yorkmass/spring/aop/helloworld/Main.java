package com.yorkmass.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArithmeticCalculator arithmeticCalculator=null;
//		arithmeticCalculator=new ArithmeticCalculatorLoggingImpl();
		ArithmeticCalculator target=new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		int result=proxy.add(1, 2);
		result=proxy.div(4, 2);
		
	}

}
