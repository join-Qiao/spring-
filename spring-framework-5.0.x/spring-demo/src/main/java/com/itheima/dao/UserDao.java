package com.itheima.dao;

import com.itheima.config.Environment;
import com.itheima.config.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.beans.ConstructorProperties;

@Repository("getUserDao")
public class UserDao implements Dao {

	@Autowired
	Environment environment;

	private String s;


	public UserDao(String s) {
	}



	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public UserDao(int i) {
	}
	public UserDao(boolean b) {
	}
	public UserDao(Man man) {
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
