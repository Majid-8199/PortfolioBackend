package com.portfolio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.portfolio.Entity.User;
import com.portfolio.Enum.Role;
import com.portfolio.Repository.UserRepository;



@SpringBootApplication
public class PortfolioBackendApplication implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<User> adminAccount=repository.findById(1);
		if(!adminAccount.isPresent()) {
			User admin=new User();
			admin.setFullname("ABDUL MAJIDE");
			admin.setDesignation("FULL STACK DEVELOPER");
			admin.setDescription("I’m a skilled software developer with expertise in both backend and frontend technologies. Proficient in Java, Spring Boot, SQL, and Angular, with a strong focus on building end-to-end solutions that prioritize user experience and performance. I also have experience in database design and optimization, RESTful API development, and implementing JWT for secure authentication to enhance application functionality.");
			admin.setEmail("majidkhobar@gmail.com");
			admin.setPh("+91 7306520412");
			admin.setInstagram("https://www.instagram.com/_maji._?igsh=anF3Y21vZWxldHNj");
			admin.setLinkedin("https://www.linkedin.com/in/abdulmajide/");
			admin.setGithub("https://github.com/Majid-8199");
			admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
			admin.setRole(Role.Admin);
			byte[] imgBytes = getImageAsBytes("/app/image/ppimage.png");
            admin.setImg(imgBytes);
            admin.setPlace("Bangalore, Karnataka");
            byte[] cvBytes = getImageAsBytes("/app/AbdulMajide.Resume.pdf");
            admin.setCv(cvBytes);
			repository.save(admin);
		}
	}
	
	private byte[] getImageAsBytes(String imagePath) {
        File imgFile = new File(imagePath);
        try {
            return Files.readAllBytes(imgFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
