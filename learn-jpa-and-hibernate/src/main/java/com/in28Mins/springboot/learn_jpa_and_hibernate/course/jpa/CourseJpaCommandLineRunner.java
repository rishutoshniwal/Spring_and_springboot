package com.in28Mins.springboot.learn_jpa_and_hibernate.course.jpa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28Mins.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJpaRepository.insertCourses(new Course(4, "Course 4", "Ranga"));
		courseJpaRepository.insertCourses(new Course(5, "Course 5", "Ranga"));
		courseJpaRepository.insertCourses(new Course(6, "Course 6", "Ranga"));
	
		courseJpaRepository.deleteCourse(4);
		
		 System.out.println(courseJpaRepository.getCourseById(6));
	}

}
