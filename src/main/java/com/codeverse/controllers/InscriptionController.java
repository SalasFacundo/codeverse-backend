package com.codeverse.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.codeverse.models.Inscription;
import com.codeverse.services.ICourseService;
import com.codeverse.services.IInscriptionService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class InscriptionController {

	@Autowired
	IInscriptionService iInscriptionService;	
	
	@Autowired
	ICourseService iCourseService;
	
	@GetMapping("/inscriptions/all")
	public ResponseEntity<?> findAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("inscriptions", iInscriptionService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/inscriptions/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("inscription", iInscriptionService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/inscriptions/new")
	public ResponseEntity<?> create(@RequestBody Inscription inscription){
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			response.put("inscription", iInscriptionService.save(inscription));
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/inscriptions/update/{id}")
	public ResponseEntity<?> update(@RequestBody Inscription inscription, @PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		Inscription updatedInscription = iInscriptionService.findById(id);		
		updatedInscription.setCourseId(inscription.getCourseId());
		updatedInscription.setStudentId(inscription.getStudentId());
		try {
			response.put("inscription", iInscriptionService.save(updatedInscription));
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("inscriptions/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		iInscriptionService.delete(id);
		response.put("mensaje", "Inscripcion eliminada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("inscriptions/CourseId/{id}")
	public ResponseEntity<?> getInscriptionByCourseId(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			response.put("Inscripciones", iInscriptionService.getInscriptionByCourseId(id));
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("inscriptions/UserId/{id}")
	public ResponseEntity<?> getInscriptionByUserId(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			response.put("Inscripciones", iInscriptionService.getInscriptionByUserId(id));
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("inscriptions/studentsByCourseId/{courseId}")
	public ResponseEntity<?> getStudentsByCourseId(@PathVariable Long courseId){
		Map<String, Object> response = new HashMap<String, Object>();
		
		response.put("usuarios", iInscriptionService.getStudentsByCourseId(courseId));
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("inscriptions/coursesByStudentId/{studentId}")
	public ResponseEntity<?> getCoursesByStudentId(@PathVariable Long studentId){
		Map<String, Object> response = new HashMap<String, Object>();
		
		response.put("courses", iInscriptionService.getCoursesByStudentId(studentId));
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("inscriptions/deleteUserFromInscription/{studentId}/{courseId}")
	public ResponseEntity<?> deleteUserFromInscription(@PathVariable Long studentId, @PathVariable Long courseId){
		Map<String, Object> response = new HashMap<String, Object>();
		iInscriptionService.deleteUserFromInscription(studentId, courseId);		 
		response.put("mensaje", "inscripcion eliminada");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}