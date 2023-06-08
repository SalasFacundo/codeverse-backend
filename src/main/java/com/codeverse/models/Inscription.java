package com.codeverse.models;

import jakarta.persistence.*;

@Entity
@Table( name = "Inscriptions")
public class Inscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToOne	 
	@JoinColumn(name = "course_id")
	Course course;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	User student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}
	
	
}
