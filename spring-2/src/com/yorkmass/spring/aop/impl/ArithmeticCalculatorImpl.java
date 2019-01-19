package com.yorkmass.spring.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result=i+j;
		System.out.println("-->"+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result=i-j;
		System.out.println("-->"+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result=i*j;
		System.out.println("-->"+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result=i/j;
		System.out.println("-->"+result);
		return result;
	}

}
