package com.codeverse.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
@JsonPropertyOrder({"id", "name", "description", "price"})
public class Course implements Serializable{
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	Long id;
	String name;
	String description;
	Double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	
		
}