package com.portfolio.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.portfolio.Dto.ProjectDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
	private String name;
    @Column(columnDefinition = "LONGTEXT")
	private String smalldescription;
    @Column(columnDefinition = "LONGTEXT")
	private String largedescription;
    @Column(columnDefinition = "LONGTEXT")
	private String techstack;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Features> features;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
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
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
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
	public String getTechstack() {
		return techstack;
	}
	public void setTechstack(String techstack) {
		this.techstack = techstack;
	}

	
	
	public Project(int id, byte[] img, String name, String smalldescription, String largedescription, String techstack,
			List<Features> features, List<Screenshots> screenshots) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.smalldescription = smalldescription;
		this.largedescription = largedescription;
		this.techstack = techstack;
		this.features = features;
		this.screenshots = screenshots;
	}
	public ProjectDTO getDTO() {
		ProjectDTO projectDTO=new ProjectDTO();
		projectDTO.setId(id);
		projectDTO.setName(name);
		projectDTO.setByteimg(img);
		projectDTO.setLargedescription(largedescription);
		projectDTO.setSmalldescription(smalldescription);
		projectDTO.setTechstack(techstack);
		projectDTO.setFeatures(features);
		projectDTO.setScreenshots(screenshots);
		return projectDTO;
	}
	
	public Project() {
		
	}
}
