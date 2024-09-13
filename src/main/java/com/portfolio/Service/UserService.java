package com.portfolio.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.portfolio.Dto.UserDTO;
import com.portfolio.Entity.User;
import com.portfolio.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserDTO updateUser(int id, UserDTO user) throws IOException {
		User user1=repository.findById(id).orElseThrow();
		user1.setFullname(user.getFullname());
		user1.setDescription(user.getDescription());
		user1.setDesignation(user.getDesignation());
		user1.setEmail(user.getEmail());
		user1.setPh(user.getPh());
		user1.setInstagram(user.getInstagram());
		user1.setLinkedin(user.getLinkedin());
		user1.setGithub(user.getGithub());
		user1.setPlace(user.getPlace());
		return repository.save(user1).getDTO();
	}
	
	public UserDTO getUser(int id) {
		Optional<User> user = repository.findById(id);
		UserDTO dto = null;
		if(user.isPresent()) {
			User user1=user.get();
			dto = user1.getDTO();
			dto.setImgBase64(Base64.getEncoder().encodeToString(user1.getImg()));
		}
		return  dto;
	}
	
	public Optional<User> getUserbyEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return repository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
			}
		};
	}
	
	public byte[] downloadCV(int userId) throws IOException {
        User user = repository.findById(userId)
                              .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        byte[] cvPdf = user.getCv();
        if (cvPdf == null || cvPdf.length == 0) {
            throw new IOException("No CV found for user with ID: " + userId);
        }
        return cvPdf;
    }
}
