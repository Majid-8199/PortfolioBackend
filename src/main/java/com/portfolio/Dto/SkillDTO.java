package com.portfolio.Dto;

import org.springframework.web.multipart.MultipartFile;

public class SkillDTO {

	private int id;
	private byte[] byteimg;
	private String name;
	private String category;
	private MultipartFile img;   
	private String imgBase64;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getByteimg() {
		return byteimg;
	}
	public void setByteimg(byte[] byteimg) {
		this.byteimg = byteimg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
