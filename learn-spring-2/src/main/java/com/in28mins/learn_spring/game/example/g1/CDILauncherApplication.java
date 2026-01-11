package com.in28mins.learn_spring.game.example.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


//@Component
@Named
class BusinessService {
	Dependency dep;

	public Dependency getDep() {
		System.out.println("Get Dependency");
		return dep;
	}

//	@Autowired
	@Inject
	public void setDep(Dependency dep) {
		System.out.println("Setter Injection");
		this.dep = dep;
	}
	
}

@Component
class Dependency {
	
}




@Configuration
@ComponentScan
public class CDILauncherApplication {
	
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(CDILauncherApplication.class);
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		context.getBean(BusinessService.class).getDep();
		
		context.close();
	
	}

}
