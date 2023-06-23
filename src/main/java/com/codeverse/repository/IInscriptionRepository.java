package com.codeverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codeverse.models.Inscription;
import com.codeverse.models.User;

public interface IInscriptionRepository extends JpaRepository<Inscription, Long> {

	 @Query("SELECT u FROM Inscription u WHERE u.courseId = :courseId")
	 List<Inscription> getInscriptionByCourseId(@Param("courseId") Long courseId);
	 
	 @Query("SELECT u FROM Inscription u WHERE u.studentId = :studentId")
	 List<Inscription> getInscriptionByUserId(@Param("studentId") Long studentId);
	 
	 @Modifying
	 @Query("DELETE FROM Inscription u WHERE u.studentId = :studentId AND u.courseId = :courseId")
	 void deleteUserFromInscription(@Param("studentId") Long studentId, @Param("courseId") Long courseId);
	 
	 @Modifying
	 @Query("DELETE FROM Inscription u WHERE u.studentId = :studentId")
	 void deleteInscriptionByUserId(@Param("studentId") Long studentId);
}
