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

import com.codeverse.models.Inscription;
import com.codeverse.services.IInscriptionService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class InscriptionController {

	@Autowired
	IInscriptionService iInscriptionService;
	
	@GetMapping("/inscriptions/all")
	public ResponseEntity<?> findAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("inscriptions", iInscriptionService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/inscriptions/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("inscription", iInscriptionService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/inscriptions/new")
	public ResponseEntity<?> create(@RequestBody Inscription inscription){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("inscription", iInscriptionService.save(inscription));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/inscriptions/update/{id}")
	public ResponseEntity<?> update(@RequestBody Inscription inscription, @PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		Inscription updatedInscription = iInscriptionService.findById(id);		
		updatedInscription.setCourseId(inscription.getCourseId());
		updatedInscription.setStudentId(inscription.getStudentId());
		response.put("inscription", iInscriptionService.save(updatedInscription));
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("inscriptions/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		iInscriptionService.delete(id);
		response.put("mensaje", "Inscripcion eliminada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}