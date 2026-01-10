package com.in28mins.learn_spring.game.example.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
	
}


@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass {
	
}

@Configuration
@ComponentScan
public class ScopeContextLauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ScopeContextLauncherApplication.class);
		
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class));
		
		
		System.out.println(context.getBean(PrototypeClass.class));
		System.out.println(context.getBean(PrototypeClass.class));
		System.out.println(context.getBean(PrototypeClass.class));
		
		
        var context2 = new AnnotationConfigApplicationContext(ScopeContextLauncherApplication.class);
		
        // This is to prove: Spring Singleton means ONE OBJECT PER IOC CONTAINER
        // i.e. Above object of normal class will be different from this one
        // because the IOC container or Application context is different for both
		System.out.println(context2.getBean(NormalClass.class));
		System.out.println(context2.getBean(NormalClass.class));
		System.out.println(context2.getBean(NormalClass.class));
		
		
	}

}
