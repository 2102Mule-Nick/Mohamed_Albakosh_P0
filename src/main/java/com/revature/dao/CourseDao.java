package com.revature.dao;

import java.util.List;

import com.revature.model.Course;

public interface CourseDao {
	public List< Course> findAllCourses();
	public Course findCoursById(int id);
	public Course findCoursByName(String name);
	public void insertCours(Course course);
	public void deleteCourse(Course course);
	public void updateCourse(Course course);

}
