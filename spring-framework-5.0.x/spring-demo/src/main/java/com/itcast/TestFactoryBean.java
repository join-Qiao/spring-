package com.itcast;

import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean<CompanyDao1> {
	@Override
	public CompanyDao1 getObject() throws Exception {
		return new CompanyDao1();
	}

	@Override
	public Class<CompanyDao1> getObjectType() {
		return CompanyDao1.class;
	}

	public void print(){
		System.out.println("testFactoryBean print");
	}
}
