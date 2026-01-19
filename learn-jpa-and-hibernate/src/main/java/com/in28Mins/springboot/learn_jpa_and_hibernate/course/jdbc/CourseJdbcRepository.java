package com.in28Mins.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28Mins.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String insertQuery = """
			
			INSERT INTO course (id, name, author) VALUES
				(?, ?, ?);
			
			""";
	
	private static String deleteQuery = """
			
			Delete from course where id = ?
			
			""";
	
	public void insertCourses(Course course) {
		springJdbcTemplate.update(insertQuery, course.getId(),
				course.getName(), course.getAuthor());
	}
	
	public void deleteCourse(long id) {
		springJdbcTemplate.update(deleteQuery, id);
	}

}
