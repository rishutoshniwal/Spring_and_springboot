package com.in28Mins.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28Mins.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertCourses(Course course) {
		entityManager.merge(course);
	}
	
	public void deleteCourse(long id) {
		Course course=entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

	public Course getCourseById(long id) {
		return entityManager.find(Course.class, id);
		
	}

}
