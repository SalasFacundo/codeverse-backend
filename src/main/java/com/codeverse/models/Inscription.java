package com.codeverse.models;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonSerializable;

import jakarta.persistence.*;

@Entity
@Table( name = "Inscriptions")
public class Inscription implements Serializable {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;	
	
	Long courseId;
	
	Long studentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", courseId=" + courseId + ", studentId=" + studentId + "]";
	}
	
	
}
