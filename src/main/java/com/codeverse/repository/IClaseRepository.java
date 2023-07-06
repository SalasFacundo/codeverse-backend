package com.codeverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codeverse.models.Clase;

public interface IClaseRepository extends JpaRepository<Clase, Long> {
	
	@Query("SELECT u FROM Clase u WHERE u.courseId = :courseId ORDER BY u.numberClass ASC")
	 List<Clase> getClasesByCourseId(@Param("courseId") Long courseId);

}