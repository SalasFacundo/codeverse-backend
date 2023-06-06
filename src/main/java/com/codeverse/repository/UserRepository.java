package com.codeverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
