package com.portfolio.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String company;
	private String designation;
	private String duration;
    @Column(columnDefinition = "TEXT")
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Experience(int id, String company, String designation, String duration, String description) {
		super();
		this.id = id;
		this.company = company;
		this.designation = designation;
		this.duration = duration;
		this.description = description;
	}
	
	public Experience() {
		
	}
}
