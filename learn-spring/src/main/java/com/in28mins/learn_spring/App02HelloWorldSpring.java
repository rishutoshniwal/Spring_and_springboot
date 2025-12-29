package com.in28mins.learn_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		
		//System.out.println(context.getBean("address"));
		/*
		 This will give this error because we changed the name of address bean:
		 Old name = "address"
		 New name = "customizedBeanNameForAddress"
		 
		Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'address' available
		at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanDefinition(DefaultListableBeanFactory.java:971)
		at org.springframework.beans.factory.support.AbstractBeanFactory.getMergedLocalBeanDefinition(AbstractBeanFactory.java:1369)
		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:296)
		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:196)
		at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1278)
		at com.in28mins.learn_spring.App02HelloWorldSpring.main(App02HelloWorldSpring.java:13)

		*/
		
//		System.out.println(context.getBean("customizedBeanNameForAddress"));
//		
//		System.out.println(context.getBean(Address.class));
		
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
	}

}
