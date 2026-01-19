package com.in28Mins.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28Mins.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insertCourses(new Course(1, "Course 1", "Ranga"));
		courseJdbcRepository.insertCourses(new Course(2, "Course 2", "Ranga"));
		courseJdbcRepository.insertCourses(new Course(3, "Course 3", "Ranga"));
	
		courseJdbcRepository.deleteCourse(1);
		
		 System.out.println(courseJdbcRepository.getCourseById(3));
	}

}
