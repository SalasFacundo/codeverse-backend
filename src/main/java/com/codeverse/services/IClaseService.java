package com.codeverse.services;

import java.util.List;

import com.codeverse.models.Clase;

public interface IClaseService {	
	public List<Clase> findAll();
	public Clase findById(Long id);	
	public Clase save(Clase clase);
	public void delete(Long id);
	public List<Clase> getClasesByCourseId(Long Id);
}
