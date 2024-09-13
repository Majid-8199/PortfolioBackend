package com.portfolio.Entity;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.portfolio.Dto.UserDTO;
import com.portfolio.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullname;
	private String designation;
	@Column(columnDefinition = "longblob")
	private byte[] img;
	@Column(columnDefinition = "longblob")
    private byte[] cv;
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	private String email;
	private String ph;
	private String instagram;
	private String linkedin;
	private String github;
	private String password;
	private String place;
	
	public byte[] getCv() {
		return cv;
	}
	public void setCv(byte[] cv) {
		this.cv = cv;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	private Role role;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public long getId() {
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
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	
	public User(int id, String fullname, String designation, byte[] img, byte[] cv, String description, String email,
			String ph, String instagram, String linkedin, String github, String password, String place, Role role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.designation = designation;
		this.img = img;
		this.cv = cv;
		this.description = description;
		this.email = email;
		this.ph = ph;
		this.instagram = instagram;
		this.linkedin = linkedin;
		this.github = github;
		this.password = password;
		this.place = place;
		this.role = role;
	}
	
	public User() {
		
	}
	
	public UserDTO getDTO() {
		UserDTO dto=new UserDTO();
		dto.setId(id);
		dto.setFullname(fullname);
		dto.setDescription(description);
		dto.setDesignation(designation);
		dto.setEmail(email);
		dto.setGithub(github);
		dto.setInstagram(instagram);
		dto.setPh(ph);
		dto.setPassword(password);
		dto.setLinkedin(linkedin);
		dto.setByteimg(img);
		dto.setRole(role);
		dto.setPlace(place);
		dto.setBytecv(cv);
		return dto;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
