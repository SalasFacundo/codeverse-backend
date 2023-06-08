package com.codeverse.services;

import java.util.List;

import com.codeverse.models.Inscription;

public interface IInscriptionService {
	public List<Inscription> findAll();
	public Inscription findById(Long id);
	public Inscription save(Inscription inscription);
	public void delete(Long id);
}
