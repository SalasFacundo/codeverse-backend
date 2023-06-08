package com.codeverse.services;

import java.util.List;

import com.codeverse.models.Course;

public interface ICourseService {
	public List<Course> findAll();
	public Course findById(Long id);
	public Course save(Course course);
	public void delete(Long id);
}
