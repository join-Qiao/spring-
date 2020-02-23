package com.itheima.compoent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

//@Component
public class TestBeanPostProcessor1 implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("1234")){
			System.out.println("我们要来参与userDao的创建了 , const before1");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("1234")){
			System.out.println("我们要来参与userDao的创建了 , const post process1");
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 1000;
	}
}
