package com.codeverse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.codeverse.models.User;
import com.codeverse.services.IInscriptionService;
import com.codeverse.services.IUserService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class InscriptionController {

	@Autowired
	IInscriptionService iInscriptionService;
	
	@GetMapping("/inscriptions/all")
	public List<Inscription> findAll(){
		return iInscriptionService.findAll();
	}
	
	@GetMapping("/inscriptions/id/{id}")
	public Inscription getById(@PathVariable Long id){
		return iInscriptionService.findById(id);
	}
	
	@PostMapping("/inscriptions/new")
	public Inscription create(@RequestBody Inscription inscription){
		return iInscriptionService.save(inscription);
	}
	
	@PutMapping("/inscriptions/update/{id}")
	public Inscription update(@RequestBody Inscription inscription, @PathVariable Long id){
		Inscription updatedInscription = iInscriptionService.findById(id);		
		updatedInscription.setCourseId(inscription.getCourseId());
		updatedInscription.setStudentId(inscription.getStudentId());
		
		return iInscriptionService.save(updatedInscription);
	}
	
	@DeleteMapping("inscriptions/delete/{id}")
	public void delete(@PathVariable Long id) {
		iInscriptionService.delete(id);
	}
}