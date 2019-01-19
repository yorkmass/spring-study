package com.yorkmass.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yorkmass.spring.beans.annotation.TestObject;

@Repository
//@Repository("userRepository")//有两个接口的实现类，就会自动找实现类对应的名字
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired(required = false)//如果没有装配TestObject，写上required=false就不会报异常了
	private TestObject testObject;
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository Save...");
		System.out.println(testObject);
	}

}
