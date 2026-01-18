package com.in28Mins.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String insertQuery = """
			
			INSERT INTO course (id, name, author) VALUES
				(1, 'Spring Boot Fundamentals', 'Ranga'),
				(2, 'JPA and Hibernate Deep Dive', 'Ranga'),
				(3, 'Microservices with Spring Cloud', 'Ranga');
			
			""";
	
	public void insertCourses() {
		springJdbcTemplate.update(insertQuery);
	}

}
