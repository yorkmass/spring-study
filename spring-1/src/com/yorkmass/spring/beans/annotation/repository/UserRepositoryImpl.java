package com.yorkmass.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yorkmass.spring.beans.annotation.TestObject;

@Repository
//@Repository("userRepository")//�������ӿڵ�ʵ���࣬�ͻ��Զ���ʵ�����Ӧ������
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired(required = false)//���û��װ��TestObject��д��required=false�Ͳ��ᱨ�쳣��
	private TestObject testObject;
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository Save...");
		System.out.println(testObject);
	}

}
