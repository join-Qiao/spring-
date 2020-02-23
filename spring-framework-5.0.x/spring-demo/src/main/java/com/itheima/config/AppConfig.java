package com.itheima.config;


import com.itcast.CompanyDao;
import com.itcast.CompanyDao1;
import com.itcast.TestFactoryBean;
import com.itheima.annotations.QN;
import com.itheima.dao.Dao;
import com.itheima.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.itheima.config")
//@QN
public class AppConfig {

	@Bean
	public Man getMan(){
		return new Man();
	}

	@Bean
	public Dao getUserDao(){
		return new UserDao(getMan());
	}

	@Bean
	public CompanyDao getCompanyDao(){
		return new CompanyDao();
	}

	@Bean
	public TestFactoryBean testFactoryBean(){
		return new TestFactoryBean();
	}
}
