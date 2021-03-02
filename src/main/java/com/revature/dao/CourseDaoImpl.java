package com.revature.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.revature.model.Course;

public class CourseDaoImpl implements CourseDao {
	private final static List<Course> COURES_LIST = new LinkedList<>();
	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return COURES_LIST;
	}

	@Override
	public Course findCoursById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCoursByName(String name) {
		
        Iterator<Course> iter = COURES_LIST.iterator();
		
		while (iter.hasNext()) {
			Course course = iter.next();
			if(course.getCourseName().equals(name)) {
				return course;
			}
		}
		return null;
	}

	@Override
	public void insertCours(Course course) {
		
		COURES_LIST.add(course);	
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

}
