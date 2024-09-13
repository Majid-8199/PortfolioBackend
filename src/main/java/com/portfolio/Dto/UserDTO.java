package com.portfolio.Dto;

import org.springframework.web.multipart.MultipartFile;
import com.portfolio.Enum.Role;

public class UserDTO {
	
	private int id;
	private String fullname;
	private String designation;
	private String description;
	private String email;
	private String ph;
	private String instagram;
	private String linkedin;
	private String github;
	private String password;
	private String place;
	private Role role;
	private MultipartFile img;   
	private String imgBase64;
	private byte[] byteimg;
	private MultipartFile cv;
	private byte[] bytecv;
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public MultipartFile getCv() {
		return cv;
	}
	public void setCv(MultipartFile cv) {
		this.cv = cv;
	}
	public byte[] getBytecv() {
		return bytecv;
	}
	public void setBytecv(byte[] bytecv) {
		this.bytecv = bytecv;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getImgBase64() {
		return imgBase64;
	}
	public void setImgBase64(String imgBase64) {
		this.imgBase64 = imgBase64;
	}
	public byte[] getByteimg() {
		return byteimg;
	}
	public void setByteimg(byte[] byteimg) {
		this.byteimg = byteimg;
	}

}
