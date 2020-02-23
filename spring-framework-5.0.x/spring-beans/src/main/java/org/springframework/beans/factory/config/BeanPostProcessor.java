/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 *
 * <p>ApplicationContexts can autodetect BeanPostProcessor beans in their
 * bean definitions and apply them to any beans subsequently created.
 * Plain bean factories allow for programmatic registration of post-processors,
 * applying to all beans created through this factory.
 *
 * <p>Typically, post-processors that populate beans via marker interfaces
 * or the like will implement {@link #postProcessBeforeInitialization},
 * while post-processors that wrap beans with proxies will normally
 * implement {@link #postProcessAfterInitialization}.
 *
 * @author Juergen Hoeller
 * @since 10.10.2003
 * @see InstantiationAwareBeanPostProcessor
 * @see DestructionAwareBeanPostProcessor
 * @see ConfigurableBeanFactory#addBeanPostProcessor
 * @see BeanFactoryPostProcessor
 */

/**
 * BeanPostProcessor是spring框架提供的一个扩展类的点（不只这一种方式）
 * 通过实现BeanPostProcessor接口,程序员就可以插手bean实例化的过程, 从而减轻了BeanFactory的压力
 * 这个接口可以设置多个,形成一个列表, 通过PriorityOrdered接口设置优先级,依次执行. 我们只需要加上Component注解,让spring进行管理即可.
 * (但是spring默认提供的类呢?  需要spring在启动的时候,自己添加进去)
 * spring 提供的类的操作接口 , 提供给我们参与spring类的创建, 正常我们启动spring项目是无法参数类的创建,有spring直接扫描,
 * 我们可以实现此接口 , 并把其加入到beanFactory的beanPostProcessors集合中即可.
 * spring对java对象的操作功能太强大, 例如: UserDao.class  我想生成 UserDao对象就是userdao对象, 想生成 代理对象就生成代理对象.
 * 这只是spring提供出来参数对象创建的一种方式 , 还是很多其他方式.
 *
 * aop也就是通过此种方式和ioc容器建立起来联系。
 * 再bean实例后期间将切面逻辑织入bean实例中。
 * AbstractAutoProxyCreator这个类， 在 postProcessBeforeInitialization， 通过proxy进行织入。
 *
 * 后置处理器可以配置多个。 类似与流水线， 会有很多步骤 ，但是每一步相对来说是独立的。
 * 但是多个后置处理器就需要进行排序， 可以实现 PriorityOrdered 接口， 可以设置优先级顺序， 越小越优先。
 */
public interface BeanPostProcessor {

	/**
	 * Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
	 * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 * or a custom init-method). The bean will already be populated with property values.
	 * The returned bean instance may be a wrapper around the original.
	 * <p>The default implementation returns the given {@code bean} as-is.
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 */
	//再类初始化之后执行， 但是再 @PostConstruct 注解的方法之前。
	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	 * Apply this BeanPostProcessor to the given new bean instance <i>after</i> any bean
	 * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 * or a custom init-method). The bean will already be populated with property values.
	 * The returned bean instance may be a wrapper around the original.
	 * <p>In case of a FactoryBean, this callback will be invoked for both the FactoryBean
	 * instance and the objects created by the FactoryBean (as of Spring 2.0). The
	 * post-processor can decide whether to apply to either the FactoryBean or created
	 * objects or both through corresponding {@code bean instanceof FactoryBean} checks.
	 * <p>This callback will also be invoked after a short-circuiting triggered by a
	 * {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation} method,
	 * in contrast to all other BeanPostProcessor callbacks.
	 * <p>The default implementation returns the given {@code bean} as-is.
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 * @see org.springframework.beans.factory.FactoryBean
	 */
	//在类初始化之之后执行 ，  但是再 @PostConstruct 注解的方法之后。
	//这个bean就是spring创建出来的Bean对象
	//那么我们想要返回什么类型的对象还不容易吗?
	//直接使用Proxy.instance()得到代理对象,返回代理对象即可.
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//这个bean就是spring创建出来的Bean对象
		//那么我们想要返回什么类型的对象还不容易吗?
		return bean;
	}

}
