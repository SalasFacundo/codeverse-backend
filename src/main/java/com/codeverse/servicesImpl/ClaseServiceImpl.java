package com.codeverse.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.models.Clase;
import com.codeverse.repository.IClaseRepository;
import com.codeverse.services.IClaseService;

@Service
public class ClaseServiceImpl implements IClaseService{
	
	@Autowired
	private IClaseRepository iClaseRepository;
	
	
	/*@Autowired
	private IInscriptionService iInscriptionService;*/
	
	@Override
	public List<Clase> findAll() {
		return iClaseRepository.findAll();
	}

	@Override
	public Clase findById(Long id) {		
		return iClaseRepository.findById(id).orElse(null);
	}

	@Override
	public Clase save(Clase clase) {		
		return iClaseRepository.save(clase);
	}

	@Override
	public void delete(Long id) {
		iClaseRepository.deleteById(id);		
	}

	@Override
	public List<Clase> getClasesByCourseId(Long id) {		
		return iClaseRepository.getClasesByCourseId(id);
	}
}
