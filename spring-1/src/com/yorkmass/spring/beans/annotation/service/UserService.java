package com.yorkmass.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yorkmass.spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	@Qualifier("userRepositoryImpl")//在装配的时候用@Qualifier指定装配哪一个指定的bean
	private UserRepository userRepository;
	/*
	 public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository){
		this.userRepository=userRepository;
		//@Qualifier注解可以加到注参的旁边如这个代码所示
	}
	 public void setUserRepository(UserRepository userRepository){
		this.userRepository=userRepository;
		//找属性名对应的bean的名字,如果@Autowired在外面就找private这个userRepository
	}
	*/
	public void add(){
		System.out.println("UserService add...");
		userRepository.save();
	}
	
	/*
	private UserRepository userRepository;
	@Autowired
	public void setUserRepository(UserRepository user1Repository){
		this.userRepository=user1Repository;
		//找属性名对应的bean的名字
	}
	public void add(){
		System.out.println("UserService add...");
		userRepository.save();
	}
	*/
}
