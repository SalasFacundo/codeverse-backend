package com.codeverse.controllers;

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

import com.codeverse.models.User;
import com.codeverse.services.IUserService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUserService iUserService;
	
	@GetMapping("/users/all")
	public ResponseEntity<?> getAll(){
		Map<String, Object> response = new HashMap<>();
		response.put("usuarios", iUserService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/users/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("usuario", iUserService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/users/new")
	public ResponseEntity<?> create(@RequestBody User user){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("usuario", iUserService.save(user));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/update/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();

		User updatedUser = iUserService.findById(id);		
		updatedUser.setName(user.getName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setDni(user.getDni());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
		
		response.put("usuario", iUserService.save(updatedUser));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("users/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		iUserService.delete(id);
		response.put("mensaje", "El usuario ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("users/validLogin/{email}/{password}")
	public ResponseEntity<?> validLogin(@PathVariable String email, @PathVariable String password){
		Map<String, Object> response = new HashMap<String, Object>();
		List<User> usuario = iUserService.validLogin(email, password);

		if(usuario.isEmpty()) {
			response.put("mensaje", "Datos incorrectos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.UNAUTHORIZED);
		} else {
			response.put("usuario", usuario);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
