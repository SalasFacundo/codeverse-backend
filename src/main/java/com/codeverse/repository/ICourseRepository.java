package com.codeverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.models.Course;

public interface ICourseRepository extends JpaRepository<Course, Long>{

}
