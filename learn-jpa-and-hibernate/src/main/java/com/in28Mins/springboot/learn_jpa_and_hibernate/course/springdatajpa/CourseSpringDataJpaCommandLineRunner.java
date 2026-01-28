package com.in28Mins.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28Mins.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

	@Override
	public void run(String... args) throws Exception {
		courseSpringDataJpaRepository.save(new Course(7, "Course 7", "Ranga"));
		courseSpringDataJpaRepository.save(new Course(8, "Course 8", "Ranga"));
		courseSpringDataJpaRepository.save(new Course(9, "Course 9", "Ranga"));

		courseSpringDataJpaRepository.deleteById(8l);
		
		System.out.println("**************************************************");

		System.out.println(courseSpringDataJpaRepository.findById(7l));
		System.out.println(courseSpringDataJpaRepository.findById(9l));
	}

}
