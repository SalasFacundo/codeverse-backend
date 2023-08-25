package com.codeverse.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
	
	@GetMapping("/users/role/{role}")
	public ResponseEntity<?> getByRole(@PathVariable String role){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("usuarios", iUserService.findByRole(role));
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
	
	@PostMapping("/users/foto/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		User user = iUserService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString()+ "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje: ", "Error al subir la imagen del cliente" + nombreArchivo);
				response.put("error: ", e.getMessage() + ": " + e.getCause().getMessage());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = user.getFoto();
			
			if(nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			user.setFoto(nombreArchivo);
			iUserService.save(user);
			
			response.put("usuario", user);
			response.put("mensaje", "Has subido correctamente la imagen:"+ nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/users/foto/ver/{nombreFoto}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("ERROR no se pudo cargar la imagen: "+nombreFoto);
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		
	}
}
