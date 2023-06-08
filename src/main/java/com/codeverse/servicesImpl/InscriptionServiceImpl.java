package com.codeverse.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.models.Inscription;
import com.codeverse.repository.IInscriptionRepository;
import com.codeverse.services.IInscriptionService;

@Service
public class InscriptionServiceImpl implements IInscriptionService {
	
	@Autowired
	IInscriptionRepository iInscriptionRepository;
	
	
	@Override
	public List<Inscription> findAll() {
		return iInscriptionRepository.findAll();
	}

	@Override
	public Inscription findById(Long id) {
		return iInscriptionRepository.findById(id).orElse(null);
	}

	@Override
	public Inscription save(Inscription inscription) {		
		return iInscriptionRepository.save(inscription);
	}

	@Override
	public void delete(Long id) {
		iInscriptionRepository.deleteById(id);		
	}

}
