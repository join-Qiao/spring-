package com.itcast;

import com.itheima.dao.Dao;
import com.itheima.invocationHandlers.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

public class CompanyDao implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("1234")){
			bean =	Proxy.newProxyInstance(bean.getClass().getClassLoader(), new Class<?>[]{Dao.class}, new MyInvocationHandler(bean));
		}
		return bean;
	}

}
