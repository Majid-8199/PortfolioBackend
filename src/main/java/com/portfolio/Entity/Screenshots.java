package com.portfolio.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.portfolio.Dto.ScreenshotsDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "screenshots")
public class Screenshots {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    @Column(columnDefinition = "longblob")
	private byte[] img;
    

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Screenshots(int id, Project project, byte[] img) {
		super();
		this.id = id;
		this.project = project;
		this.img = img;
	}
	
	public Screenshots() {
		// TODO Auto-generated constructor stub
	}

	public ScreenshotsDTO getDTO() {
		ScreenshotsDTO screenshotsDTO=new ScreenshotsDTO();
		screenshotsDTO.setId(id);
		screenshotsDTO.setByteimg(img);
		return screenshotsDTO;
	}

}
