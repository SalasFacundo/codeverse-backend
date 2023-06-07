package com.codeverse.services;

import java.util.List;

import com.codeverse.models.Course;

public interface ICourseService {
	public List<Course> getAll();
	public Course getById(Long id);
	public Course save(Course Course);
	public void delete(Long id);
}
