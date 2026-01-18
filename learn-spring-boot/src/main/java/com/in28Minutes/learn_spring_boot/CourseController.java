package com.in28Minutes.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1, "Java", "in28Min"),
//				new Course(2, "Springboot", "in28Min"),
				new Course(3, "AWS", "in28Min")
				);
	}

}
