package com.codeverse.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.models.Course;
import com.codeverse.repository.ICourseRepository;
import com.codeverse.repository.IInscriptionRepository;
import com.codeverse.services.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private ICourseRepository iCourseRepository;
	
	@Autowired
	private IInscriptionRepository iInscriptionRepository;
	
	@Override
	public List<Course> findAll() {
		return iCourseRepository.findAll();
	}

	@Override
	public Course findById(Long id) {		
		return iCourseRepository.findById(id).orElse(null);
	}

	@Override
	public Course save(Course course) {		
		return iCourseRepository.save(course);
	}

	@Override
	public void delete(Long id) {
		iInscriptionRepository.deleteInscriptionByCourseId(id);
		iCourseRepository.deleteById(id);		
	}

}
