package com.codeverse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.models.User;
import com.codeverse.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepository;
	
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

}
