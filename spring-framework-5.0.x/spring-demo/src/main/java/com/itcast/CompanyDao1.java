package com.itcast;

import com.itheima.dao.Dao;
import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyDao1 implements Dao {

	@Override
	public void query() {
		System.out.println("companyDao 1 ");
	}



	@Autowired
	UserDao userDao;

	public void testUserDao(){
		userDao.query();
	}
}
