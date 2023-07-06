package com.codeverse.services;

import java.util.List;

import com.codeverse.models.Course;
import com.codeverse.models.Inscription;
import com.codeverse.models.User;

public interface IInscriptionService {
	public List<Inscription> findAll();
	public Inscription findById(Long id);
	public Inscription save(Inscription inscription) throws Exception;
	public void delete(Long id);
	public List<Inscription> getInscriptionByCourseId(Long id) throws Exception;
	public List<Inscription> getInscriptionByUserId(Long id) throws Exception;
	public List<User> getUsersByCourseIdAndRole(Long id, String role);
	public void deleteUserFromInscription(Long studentId, Long courseId);
	public List<Course> getCoursesByStudentId(Long studentId);
	public List<Course> getCoursesNotBuyedByStudentId(Long studentId);
}
