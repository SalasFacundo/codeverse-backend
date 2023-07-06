package com.codeverse.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeverse.models.Course;
import com.codeverse.models.Inscription;
import com.codeverse.models.User;
import com.codeverse.repository.ICourseRepository;
import com.codeverse.repository.IInscriptionRepository;
import com.codeverse.services.ICourseService;
import com.codeverse.services.IInscriptionService;
import com.codeverse.services.IUserService;

import jakarta.transaction.Transactional;

@Service
public class InscriptionServiceImpl implements IInscriptionService {
	
	@Autowired
	IInscriptionRepository iInscriptionRepository;
	
	@Autowired
	ICourseRepository iCourseRepository;

	@Autowired
	IUserService iUserService;

	@Autowired
	ICourseService iCourseService;

	@Override
	public List<Inscription> findAll() {
		return iInscriptionRepository.findAll();
	}

	@Override
	public Inscription findById(Long id) {
		return iInscriptionRepository.findById(id).orElse(null);
	}

	@Override
	public Inscription save(Inscription inscription) throws Exception {
		
		Course course = iCourseService.findById(inscription.getCourseId());
		User user = iUserService.findById(inscription.getStudentId());		
		
		if(course != null && user != null) {
			return iInscriptionRepository.save(inscription);		
		} else {
			throw new Exception("Usuario o curso inexistente");
		}
	}

	@Override
	public void delete(Long id) {
		iInscriptionRepository.deleteById(id);		
	}

	@Override
	public List<Inscription> getInscriptionByCourseId(Long id) throws Exception{
		List<Inscription> inscriptions = iInscriptionRepository.getInscriptionByCourseId(id);
		
		if(inscriptions.isEmpty()) {
			throw new Exception("No existen inscripciones con el curso");
		} else {
			return inscriptions;
		}
		
	}

	@Override
	public List<Inscription> getInscriptionByUserId(Long id) throws Exception{
		List<Inscription> inscriptions = iInscriptionRepository.getInscriptionsByUserId(id);
		
		if(inscriptions.isEmpty()) {
			throw new Exception("No existen inscripciones con el usuario");
		} else {
			return inscriptions;
		}
		
	}

	@Override
	public List<User> getUsersByCourseIdAndRole(Long id, String role){
		List<Inscription> inscriptions = iInscriptionRepository.getInscriptionByCourseId(id);
		List<User> students = new ArrayList<User>();
		
		inscriptions.stream().forEach( inscription -> {
			User user = iUserService.findById(inscription.getStudentId());
			if(user.getRole().equals(role)) {
				students.add(user);				
			}
		});		
		return students;
	}

	@Transactional
	@Override	
	public void deleteUserFromInscription(Long studentId, Long courseId){
		iInscriptionRepository.deleteUserFromInscription(studentId, courseId);
	}
	
	@Override
	public List<Course> getCoursesByStudentId(Long studentId){

		List<Inscription> inscriptions = new ArrayList<Inscription>();
		List<Course> courses = new ArrayList<Course>();
		
		try {
			inscriptions = this.getInscriptionByUserId(studentId);
			inscriptions.stream().forEach(inscription -> {
				courses.add(iCourseService.findById(inscription.getCourseId()));
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return courses;
	}
	
	@Override
	public List<Course> getCoursesNotBuyedByStudentId(Long studentId){		
		List<Course> allCourses = iCourseRepository.findAll();
		List<Course> studentCourses =this.getCoursesByStudentId(studentId);
		
		List<Course> nonMatchingCourses = new ArrayList<>();
		
		for (Course course : allCourses) {
		    if (!studentCourses.contains(course)) {
		        nonMatchingCourses.add(course);
		    }
		}		
		
		return nonMatchingCourses;
	}
	
	

}
