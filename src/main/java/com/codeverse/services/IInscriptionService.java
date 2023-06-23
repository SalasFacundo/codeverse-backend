package com.codeverse.services;

import java.util.List;

import com.codeverse.models.Inscription;
import com.codeverse.models.User;

public interface IInscriptionService {
	public List<Inscription> findAll();
	public Inscription findById(Long id);
	public Inscription save(Inscription inscription) throws Exception;
	public void delete(Long id);
	public List<Inscription> getInscriptionByCourseId(Long id) throws Exception;
	public List<Inscription> getInscriptionByUserId(Long id) throws Exception;
	public List<User> getStudentsByCourseId(Long id);
	public void deleteUserFromInscription(Long studentId, Long courseId);
}
