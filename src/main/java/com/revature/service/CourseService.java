package com.revature.service;

import java.util.List;

import com.revature.dao.CourseDao;
import com.revature.dao.CourseDaoImpl;
import com.revature.model.Course;

public class CourseService {
	private CourseDao courseDao;

	public CourseService() {
		this.courseDao = new CourseDaoImpl();
	}

	public List<Course> findAllCourses() {
		
		return this.courseDao.findAllCourses();
	}

	
	public Course findCoursById(int id) {
		
		return this.courseDao.findCoursById(id);
	}

	
	public Course findCoursByName(String name) {
		
		return this.courseDao.findCoursByName(name);
	}

	
	public void insertCours(Course course) {
		
		this.courseDao.insertCours(course);
	}

	
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}


}
