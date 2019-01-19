package com.yorkmass.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yorkmass.spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	@Qualifier("userRepositoryImpl")//��װ���ʱ����@Qualifierָ��װ����һ��ָ����bean
	private UserRepository userRepository;
	/*
	 public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository){
		this.userRepository=userRepository;
		//@Qualifierע����Լӵ�ע�ε��Ա������������ʾ
	}
	 public void setUserRepository(UserRepository userRepository){
		this.userRepository=userRepository;
		//����������Ӧ��bean������,���@Autowired���������private���userRepository
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
		//����������Ӧ��bean������
	}
	public void add(){
		System.out.println("UserService add...");
		userRepository.save();
	}
	*/
}
