package com.portfolio.Dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.Entity.Project;

public class ScreenshotsDTO {

	private int id;
    private Project project;
	private byte[] byteimg;
	@JsonIgnore
	private MultipartFile img;
	private String imgBase64;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public byte[] getByteimg() {
		return byteimg;
	}
	public void setByteimg(byte[] byteimg) {
		this.byteimg = byteimg;
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
	public ScreenshotsDTO(int id, Project project, byte[] byteimg, MultipartFile img, String imgBase64) {
		super();
		this.id = id;
		this.project = project;
		this.byteimg = byteimg;
		this.img = img;
		this.imgBase64 = imgBase64;
	}	
	public ScreenshotsDTO() {
		// TODO Auto-generated constructor stub
	}
}
