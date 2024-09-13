package com.portfolio.Entity;

import com.portfolio.Dto.SkillDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(columnDefinition = "longblob")
	private byte[] img;
	private String name;
	private String category;
	
	public long getId() {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Skill(int id, byte[] img, String name, String category) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.category = category;
	}
	
	public Skill() {
	
	}

	public SkillDTO getDTO() {
		SkillDTO skillDTO=new SkillDTO();
		skillDTO.setId(id);
		skillDTO.setName(name);
		skillDTO.setByteimg(img);
		skillDTO.setCategory(category);
		return skillDTO;
	}
}
