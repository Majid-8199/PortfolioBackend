package com.portfolio.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.Dto.ContactDTO;
import com.portfolio.Dto.JwtAuthenticationRequest;
import com.portfolio.Dto.LoginRequest;
import com.portfolio.Dto.ProjectDTO;
import com.portfolio.Dto.RefreshTokenRequest;
import com.portfolio.Dto.ScreenshotsDTO;
import com.portfolio.Dto.SkillDTO;
import com.portfolio.Dto.UserDTO;
import com.portfolio.Entity.Certification;
import com.portfolio.Entity.Education;
import com.portfolio.Entity.Experience;
import com.portfolio.Entity.Features;
import com.portfolio.Entity.Skill;
import com.portfolio.Service.AuthenticationService;
import com.portfolio.Service.CertificationService;
import com.portfolio.Service.ContactService;
import com.portfolio.Service.EducationService;
import com.portfolio.Service.ExperienceService;
import com.portfolio.Service.ProjectService;
import com.portfolio.Service.SkillService;
import com.portfolio.Service.UserService;

@RestController
@RequestMapping("/all")
@CrossOrigin("http://localhost")
public class AllController {

	@Autowired
    private CertificationService certificationService;
	
	@Autowired
    private ProjectService projectService;
	
	@Autowired
    private ExperienceService experienceService;
	
	@Autowired
    private EducationService educationService;
	
	@Autowired
    private SkillService skillService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@GetMapping("/getuser")
	public UserDTO getUser() {
		return userService.getUser(1);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthenticationRequest> login(@RequestBody LoginRequest loginRequest) throws IllegalAccessException{
		return ResponseEntity.ok(authenticationService.login(loginRequest));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<JwtAuthenticationRequest> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
		return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
	}
	
	@GetMapping("/getallskill")
    public List<SkillDTO> getAllSkill() {
        return skillService.getAllSkill();
    }

    @GetMapping("/getskill/{id}")
    public SkillDTO getSkillbyId(@PathVariable int id) {
    	return skillService.getSkillbyId(id);
    }

    @GetMapping("/getalleducation")
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }
    
    @GetMapping("/geteducation/{id}")
    public Optional<Education> getEducationbyId(@PathVariable int id) {
    	return educationService.getEducationbyId(id);
    }
	
	@GetMapping("/getallcertification")
    public List<Certification> getAllCertification() {
        return certificationService.getAllCertification();
    }
	
	@GetMapping("/getcertification/{id}")
    public Optional<Certification> getCertificationbyId(@PathVariable int id) {
    	return certificationService.getCertificationbyId(id);
    }
	
    @GetMapping("/getallproject")
    public List<ProjectDTO> getAllProject() {
        return projectService.getAllProjects();
    }
    
    @GetMapping("/getproject/id/{id}")
    public ProjectDTO getProjectbyId(@PathVariable int id) {
    	return projectService.getProjectbyId(id);
    }
    
    @GetMapping("/getproject/name/{name}")
    public ProjectDTO getProjectbyName(@PathVariable String name) {
    	return projectService.getProjectbyName(name);
    }
	
    @GetMapping("/getallexperience")
    public List<Experience> getAllExperience() {
        return experienceService.getAllExperience();
    }
    
    @GetMapping("/getexperience/{id}")
    public Optional<Experience> getExperiencebyId(@PathVariable int id) {
    	return experienceService.getExperiencebyId(id);
    }
    
    @GetMapping("/projectscreenshots/{projectId}")
    public List<ScreenshotsDTO> getScreenshotsByProjectId(@PathVariable int projectId){
    	return projectService.getScreenshotsByProjectId(projectId);
    }
    
    @GetMapping("/projectfeatures/{projectId}")
    public List<Features> getFeaturesByProjectId(@PathVariable int projectId){
    	return projectService.getFeaturesByProjectId(projectId);    	
    }
    
    @PostMapping("/sendmail")
    public void sendMessage(@RequestBody ContactDTO contactDTO) {
        contactService.sendEmail(contactDTO);
        System.out.println("Mail send successfully!");
    }
    
    @GetMapping("/download/{id}")
	public byte[] downloadCV(@PathVariable int id) throws IOException{
		return userService.downloadCV(id);
	}
}
