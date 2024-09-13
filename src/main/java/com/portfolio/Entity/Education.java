package com.portfolio.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String college;
	private String place;
	private String duration;
	private String course;
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public Education(int id, String college, String place, String duration, String course) {
		super();
		this.id = id;
		this.college = college;
		this.place = place;
		this.duration = duration;
		this.course = course;
	}
	
	public Education() {
	
	}

}
