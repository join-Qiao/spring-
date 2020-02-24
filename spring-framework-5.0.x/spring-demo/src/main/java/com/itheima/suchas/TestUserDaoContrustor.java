package com.itheima.suchas;

import com.itheima.config.Man;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserDaoContrustor {

	@Autowired
	CompanyDaoforTestUserDao testUserDao;

	public TestUserDaoContrustor(String s) {
	}
	public TestUserDaoContrustor(int i) {
	}
	public TestUserDaoContrustor(boolean b) {
	}
	public TestUserDaoContrustor(Man man) {
	}
}
