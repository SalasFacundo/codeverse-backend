package com.codeverse.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.models.User;
import com.codeverse.repository.IUserRepository;
import com.codeverse.services.IUserService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	@Transactional( readOnly = true)
	public List<User> getAll() {	
		return userRepository.findAll();
	}

	@Override
	@Transactional( readOnly = true)
	public User getById(Long id) {		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional( readOnly = false)
	public User save(User user) {		
		return userRepository.save(user);
	}

	@Override
	@Transactional( readOnly = false)
	public void delete(Long id) {
		userRepository.deleteById(id);		
	}

	@Transactional( readOnly = true)
	public List<User> validLogin(String email, String password) {
		return userRepository.validLogin(email, password);
	}

}
