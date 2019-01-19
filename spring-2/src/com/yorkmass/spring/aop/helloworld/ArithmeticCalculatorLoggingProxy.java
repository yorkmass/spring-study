package com.yorkmass.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ArithmeticCalculatorLoggingProxy {

	//Ҫ����Ķ���
	private ArithmeticCalculator targer;
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		// TODO Auto-generated constructor stub
		this.targer=target;
	}
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy=null;
		//�����������һ����������������
		ClassLoader loader=targer.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces=new Class[]{ArithmeticCalculator.class};
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h=new InvocationHandler() {
			/**
			 * proxy:���ڷ��ص��Ǹ��������һ������£���invoke�����ж������øö���
			 * method:���ڵ��õķ���
			 * args:���÷���ʱ������Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName=method.getName();
				//��ӡ��־
				//ǰ��֪ͨ
				System.out.println("The method..."+methodName+"begins with"+Arrays.asList(args));
				//����Ŀ�귽��
				Object result=null;
				try {
	
					result=method.invoke(targer, args);
					//����֪ͨ,���Է��ʵ������ķ���ֵ
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					//�쳣֪ͨ�����Է��ʵ��������ֵ��쳣
				}
				//����֪ͨ����Ϊ�������ܻ���쳣���Է��ʲ��������ķ���ֵ
				//��ӡ��־
				System.out.println("The method"+methodName+"ends with "+result);
				return result;
			}
		};

		proxy=(ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
