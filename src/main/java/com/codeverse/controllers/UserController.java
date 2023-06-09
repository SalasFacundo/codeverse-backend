package com.codeverse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.codeverse.models.User;
import com.codeverse.services.IUserService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUserService iUserService;
	
	@GetMapping("/users/all")
	public List<User> getAll(){
		return iUserService.getAll();
	}
	
	@GetMapping("/users/id/{id}")
	public User getById(@PathVariable Long id){
		return iUserService.getById(id);
	}
	
	@PostMapping("/users/new")
	public User create(@RequestBody User user){
		return iUserService.save(user);
	}
	
	@PutMapping("/users/update/{id}")
	public User update(@RequestBody User user, @PathVariable Long id){
		User updatedUser = iUserService.getById(id);		
		updatedUser.setName(user.getName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setDni(user.getDni());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
		
		return iUserService.save(updatedUser);
	}
	
	@DeleteMapping("users/delete/{id}")
	public void delete(@PathVariable Long id) {
		iUserService.delete(id);
	}
}
