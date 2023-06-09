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
import com.codeverse.services.ICourseService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class CourseController {

	@Autowired
	ICourseService iCourseService;
	
	@GetMapping("/courses/all")
	public List<Course> getAll(){
		return iCourseService.findAll();
	}
	
	@GetMapping("/courses/id/{id}")
	public Course getById(@PathVariable Long id) {
		return iCourseService.findById(id);
	}
	
	@PostMapping("/courses/new")
	public Course create(@RequestBody Course course) {
		return iCourseService.save(course);
	}
	
	@PutMapping("/courses/update/{id}")
	public Course update(@RequestBody Course course, @PathVariable Long id) {
		Course updatedCourse = iCourseService.findById(id);
		updatedCourse.setName(course.getName());
		updatedCourse.setDescription(course.getDescription());
		updatedCourse.setCapacity(course.getCapacity());
		updatedCourse.setTeacherId(course.getTeacherId());
		updatedCourse.setClassesId(course.getClassesId());
		updatedCourse.setPrice(course.getPrice());
		updatedCourse.setStartDate(course.getStartDate());
		updatedCourse.setEndDate(course.getEndDate());
		updatedCourse.setStartHour(course.getStartHour());
		updatedCourse.setEndHour(course.getEndHour());
		return iCourseService.save(updatedCourse);
	}
	
	@DeleteMapping("/courses/delete/{id}")
	public void delete(@PathVariable Long id) {
		iCourseService.delete(id);
	}
}
