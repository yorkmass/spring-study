package com.yorkmass.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository("user1Repository")
public class UserJdbcRepository implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserJdbcRepository save...");
	}

}
