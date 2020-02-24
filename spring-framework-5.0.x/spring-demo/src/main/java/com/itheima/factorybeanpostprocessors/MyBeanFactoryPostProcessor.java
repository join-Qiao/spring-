package com.itheima.factorybeanpostprocessors;

import com.itheima.suchas.TestUserDaoContrustor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor , Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("myBeanFactoryPostProcessor");
//		Object bean = beanFactory.getBean("1234");
//		System.out.println("bean : " + bean);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("getUserDao");
//		beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);

		// 这是构造参数的值 , 我们可以自己定义beanDefinition , 使用那一个构造方法去创建对象.
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("1234"); // issue #59
		// beanClass , 我们可以指定这个BeanDefinition使用哪一个类来创建, 因为FactoryBean存在, 所以不一定是自己本类创建自己.
//		beanDefinition.setBeanClass(TestUserDaoContrustor.class);
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
