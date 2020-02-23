package com.itheima.dao;

import com.itheima.config.Environment;
import com.itheima.config.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

//@Repository("1234")
public class UserDao implements Dao {

	@Autowired
	Environment environment;

	public UserDao(Man man) {
		System.out.println("user dao constructor");
	}

	@PostConstruct
	public void init(){
		System.out.println("userDao  init ()");
	}

	@Override
	public void query(){
		System.out.println("userDao   query  method");
	}
}
