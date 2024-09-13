package com.portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portfolio.Dto.ContactDTO;

@Service
public class ContactService {
	
	@Autowired
    private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String fromEmailId;
	
    public ContactDTO sendEmail(ContactDTO dto) {
    	
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(fromEmailId);
        mail.setTo(fromEmailId);
        mail.setSubject("Contact Form Submission");
        mail.setText("Name: " + dto.getFirstname() + " " + dto.getLastname() +
                         "\nEmail: " + dto.getEmail() +
                         "\nMobile Number: " + dto.getPh() +
                         "\n" + dto.getMessage());

        mailSender.send(mail);
        return dto;
    }
}
