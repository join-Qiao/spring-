package com.itheima.factorybeanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

//@Component
public class MyBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor , Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("myBeanFactoryPostProcessor");
//		Object bean = beanFactory.getBean("1234");
//		System.out.println("bean : " + bean);
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("1234");
		beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("my postProcessBeanDefinitionRegistry");

	}

	@Override
	public int getOrder() {
		return 0;
	}
}
