package com.codeverse.controllers;

import java.util.HashMap;
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

import com.codeverse.models.Clase;
import com.codeverse.services.IClaseService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class ClaseController {
	
	@Autowired
	IClaseService iClaseService;
	
	@GetMapping("/clases/all")
	public ResponseEntity<?> getAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("courses", iClaseService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/clases/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("course", iClaseService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/clases/new")
	public ResponseEntity<?> create(@RequestBody Clase clase) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("course", iClaseService.save(clase));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/clases/update/{id}")
	public ResponseEntity<?> update(@RequestBody Clase clase, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();

		Clase updatedClase = iClaseService.findById(id);
		
		updatedClase.setCourseid(clase.getCourseid());
		updatedClase.setNumberClass(clase.getNumberClass());
		updatedClase.setName(clase.getName());
		updatedClase.setDescription(clase.getDescription());
		response.put("clases", iClaseService.save(updatedClase));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clases/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		iClaseService.delete(id);
		response.put("mensaje", "La clase ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/clases/courseId/{id}")
	public ResponseEntity<?> getClasesByCourseId(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("clases", iClaseService.getClasesByCourseId(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
