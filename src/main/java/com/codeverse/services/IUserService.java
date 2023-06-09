package com.codeverse.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.codeverse.models.User;

public interface IUserService{
	public List<User> getAll();
	public User getById(Long id);
	public User save(User user);
	public void delete(Long id);
	public List<User> validLogin(String email, String password);
}
