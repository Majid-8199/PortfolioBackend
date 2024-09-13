package com.portfolio.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.Dto.ProjectDTO;
import com.portfolio.Dto.ScreenshotsDTO;
import com.portfolio.Dto.SkillDTO;
import com.portfolio.Dto.UserDTO;
import com.portfolio.Entity.Certification;
import com.portfolio.Entity.Education;
import com.portfolio.Entity.Experience;
import com.portfolio.Entity.Features;
import com.portfolio.Entity.Screenshots;
import com.portfolio.Entity.User;
import com.portfolio.Service.CertificationService;
import com.portfolio.Service.EducationService;
import com.portfolio.Service.ExperienceService;
import com.portfolio.Service.ProjectService;
import com.portfolio.Service.SkillService;
import com.portfolio.Service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost")
public class AdminController {

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

    @PostMapping("/addskill")
    public SkillDTO addSkill(@ModelAttribute SkillDTO experience) throws IOException {
        return skillService.addSkill(experience);
    }

    @PutMapping("/updateskill/{id}")
    public SkillDTO updateSkill(@PathVariable int id, @RequestBody SkillDTO skill) throws IOException {
        return skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/deleteskill/{id}")
    public void deleteSkill(@PathVariable int id) {
    	skillService.deleteSkill(id);
    }
    
	
	@PostMapping("/addeducation")
    public Education addEducation(@RequestBody Education education) {
        return educationService.addEducation(education);
    }

    @PutMapping("/updateeducation/{id}")
    public Education updateEducation(@PathVariable int id, @RequestBody Education education) {
        return educationService.updateEducation(id, education);
    }

    @DeleteMapping("/deleteeducation/{id}")
    public void deleteEducation(@PathVariable int id) {
    	educationService.deleteEducation(id);
    }
	
    @PostMapping("/addcertification")
    public Certification addCertification(@RequestBody Certification certification) {
        return certificationService.addCertification(certification);
    }

    @PutMapping("/updatecertification/{id}")
    public Certification updateCertification(@PathVariable int id, @RequestBody Certification certification) {
        return certificationService.updateCertification(id, certification);
    }

    @DeleteMapping("/deletecertification/{id}")
    public void deleteCertification(@PathVariable int id) {
    	certificationService.deleteCertification(id);
    }
    
    @PostMapping("/addproject")
    public ProjectDTO addProject(@ModelAttribute ProjectDTO project) throws IOException {
        return projectService.addProject(project);
    }

    @PutMapping("/updateproject/{id}")
    public ProjectDTO updateProject(@PathVariable int id, @RequestBody ProjectDTO project) throws IOException {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/deleteproject/{id}")
    public void deleteProject(@PathVariable int id) {
    	projectService.deleteProject(id);
    }
    
    @PostMapping("/addexperience")
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }

    @PutMapping("/updateexperience/{id}")
    public Experience updateExperience(@PathVariable int id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }

    @DeleteMapping("/deleteexperience/{id}")
    public void deleteExperience(@PathVariable int id) {
    	experienceService.deleteExperience(id);
    }
    
    @PostMapping("/addfeature/{name}")
    public void addFeatureToProject(@PathVariable String name, @RequestBody Features feature) {
        projectService.addFeature(name, feature);
    }
    
    @PutMapping("/updatefeature/{id}")
    public Features updateFeature(@PathVariable int id, @RequestBody Features feature) {
        return projectService.updateFeature(id, feature);
    }

    @DeleteMapping("/deletefeature/{id}")
    public void deleteFeature(@PathVariable int id) {
    	projectService.deleteFeature(id);
    }
    
    @PostMapping("/addscreenshot/{name}")
    public ScreenshotsDTO addScreenshotToProject(@PathVariable String name, @ModelAttribute ScreenshotsDTO screenshotDTO) throws IOException {
        return projectService.addScreenshotToProject(name, screenshotDTO);
    }
    
    @PutMapping("/updatescreenshot/{id}")
    public Screenshots updateScreenshot(@PathVariable int id, @RequestBody Screenshots screenshot) {
        return projectService.updateScreenshot(id, screenshot);
    }

    @DeleteMapping("/deletescreenshot/{id}")
    public void deleteScreenshot(@PathVariable int id) {
    	projectService.deleteScreenshotFromProject(id);
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO user) throws IOException {
        return userService.updateUser(1, user);
    }
}
