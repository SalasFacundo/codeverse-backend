package com.codeverse.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

@Entity
@Table(name="users")
@JsonPropertyOrder({"id", "lastName", "type"})
public class User implements Serializable{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;	
	String name;
	
	@Column(name = "last_name")
	String lastName;
	int type;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
