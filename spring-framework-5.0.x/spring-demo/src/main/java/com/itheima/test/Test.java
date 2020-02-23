package com.itheima.test;

		import com.itcast.CompanyDao1;
		import com.itcast.TestFactoryBean;
		import com.itheima.config.AppConfig;
		import com.itheima.dao.Dao;
		import com.itheima.factorybeanpostprocessors.MyBeanRegisterFactoryPostProcessor;
		import com.itheima.dao.UserDao;
		import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//		annotationConfigApplicationContext.addBeanFactoryPostProcessor(new MyBeanRegisterFactoryPostProcessor());
//		annotationConfigApplicationContext.scan("com.itheima");
		annotationConfigApplicationContext.register(AppConfig.class);
		annotationConfigApplicationContext.refresh();

		AppConfig bean = annotationConfigApplicationContext.getBean(AppConfig.class);
		System.out.println(bean);

//		Dao userDao = bean.getUserDao();


		CompanyDao1 testFactoryBean = (CompanyDao1) annotationConfigApplicationContext.getBean("testFactoryBean");
//		testFactoryBean.testUserDao();
//		bean1.print();
		System.out.println(testFactoryBean.getClass());

//		Dao userDao = annotationConfigApplicationContext.getBean(Dao.class);
//		UserDao userDao1 = annotationConfigApplicationContext.getBean(UserDao.class);
//		System.out.println("userDao.hashcode : " + userDao.hashCode());
//		System.out.println("userDao1.hashcode : " + userDao1.hashCode());
//		userDao.query();


	}
}
