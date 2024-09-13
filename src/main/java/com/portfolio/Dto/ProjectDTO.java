package com.portfolio.Dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.portfolio.Entity.Features;
import com.portfolio.Entity.Screenshots;


public class ProjectDTO {

	private int id;
	private String name;
	private String smalldescription;
	private String largedescription;
	private byte[] byteimg;
	private String techstack;
	private MultipartFile img;
	private String imgBase64;
	private List<Features> features;
	private List<Screenshots> screenshots;
	
	public List<Screenshots> getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(List<Screenshots> screenshots) {
		this.screenshots = screenshots;
	}
	public List<Features> getFeatures() {
		return features;
	}
	public void setFeatures(List<Features> features) {
		this.features = features;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSmalldescription() {
		return smalldescription;
	}
	public void setSmalldescription(String smalldescription) {
		this.smalldescription = smalldescription;
	}
	public String getLargedescription() {
		return largedescription;
	}
	public void setLargedescription(String largedescription) {
		this.largedescription = largedescription;
	}
	public byte[] getByteimg() {
		return byteimg;
	}
	public void setByteimg(byte[] byteimg) {
		this.byteimg = byteimg;
	}
	public String getTechstack() {
		return techstack;
	}
	public void setTechstack(String techstack) {
		this.techstack = techstack;
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
}
