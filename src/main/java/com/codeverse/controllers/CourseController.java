package com.codeverse.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("courses", iCourseService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/courses/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("course", iCourseService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/courses/new")
	public ResponseEntity<?> create(@RequestBody Course course) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("course", iCourseService.save(course));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/courses/update/{id}")
	public ResponseEntity<?> update(@RequestBody Course course, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();

		Course updatedCourse = iCourseService.findById(id);
		
		System.out.println("CURSO ENCONTRADO");
		System.out.println(updatedCourse);
		
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
		response.put("courses", iCourseService.save(updatedCourse));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/courses/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		iCourseService.delete(id);
		response.put("mensaje", "El curso ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
