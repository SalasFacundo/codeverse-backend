package com.codeverse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeverse.models.Course;
import com.codeverse.repository.ICourseRepository;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class CourseController {

	@Autowired
	ICourseRepository iCourseRepository;
	
	@GetMapping("/courses/all")
	public List<Course> getAll(){
		return iCourseRepository.findAll();
	}
	
	@GetMapping("/courses/id/{id}")
	public Course getById(@PathVariable Long id) {
		return iCourseRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/courses/new")
	public Course create(@RequestBody Course course) {
		return iCourseRepository.save(course);
	}
	
	@PutMapping("/courses/update/{id}")
	public Course update(@RequestBody Course course, @PathVariable Long id) {
		Course updatedCourse = iCourseRepository.findById(id).orElse(null);
		updatedCourse.setName(course.getName());
		updatedCourse.setPrice(course.getPrice());
		updatedCourse.setDescription(course.getDescription());		
		return iCourseRepository.save(updatedCourse);
	}
	
	@DeleteMapping("/courses/delete/{id}")
	public void delete(@PathVariable Long id) {
		iCourseRepository.deleteById(id);
	}
}
