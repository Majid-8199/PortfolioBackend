package com.portfolio.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.Dto.ProjectDTO;
import com.portfolio.Dto.ScreenshotsDTO;
import com.portfolio.Entity.Features;
import com.portfolio.Entity.Project;
import com.portfolio.Entity.Screenshots;
import com.portfolio.Repository.FeatureRepository;
import com.portfolio.Repository.ProjectRepository;
import com.portfolio.Repository.ScreenshotRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;
    
    @Autowired
    private FeatureRepository featureRepository;
    
    @Autowired
    private ScreenshotRepository screenshotsRepository;
    
    public List<ProjectDTO> getAllProjects() {
    	List<Project> projects = repository.findAll();
        return projects.stream().map(project -> {
            ProjectDTO dto = project.getDTO();
            dto.setImgBase64(Base64.getEncoder().encodeToString(project.getImg()));
            return dto;
        }).collect(Collectors.toList());    }
    
    public ProjectDTO getProjectbyId(int id) {
    	Optional<Project> project=repository.findById(id);
    	if (project.isPresent()) {
    		ProjectDTO dto=project.get().getDTO();
        	dto.setImgBase64(Base64.getEncoder().encodeToString(project.get().getImg()));
        	return dto;
        } else {
            throw new NoSuchElementException("Project with ID " + id + " not found");
        }
    	
    }
    
    public ProjectDTO getProjectbyName(String name) {
    	Optional<Project> project=repository.findByName(name);
    	ProjectDTO dto=project.get().getDTO();
    	dto.setImgBase64(Base64.getEncoder().encodeToString(project.get().getImg()));
    	return dto;
    }

    public ProjectDTO addProject(ProjectDTO projectDTO) throws IOException {
    	Project project=new Project();
    	project.setName(projectDTO.getName());
    	project.setLargedescription(projectDTO.getLargedescription());
    	project.setImg(projectDTO.getImg().getBytes());
    	project.setSmalldescription(projectDTO.getSmalldescription());
    	project.setTechstack(projectDTO.getTechstack());
        return repository.save(project).getDTO();
    }

    public ProjectDTO updateProject(int id, ProjectDTO projectDTO) throws IOException {
    	Project project = repository.findById(id)
    	        .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
    	project.setName(projectDTO.getName());
    	project.setLargedescription(projectDTO.getLargedescription());
    	project.setSmalldescription(projectDTO.getSmalldescription());
    	project.setTechstack(projectDTO.getTechstack());
        return repository.save(project).getDTO();
    }

    public void deleteProject(int id) {
        repository.deleteById(id);
    }

    public void addFeature(String name, Features feature) {
        Project project = repository.findByName(name).orElseThrow(() -> new NoSuchElementException("Project not found: " + name));
        project.getFeatures().add(feature);
        feature.setProject(project); 
        Project updatedProject = repository.save(project);
        updatedProject.getFeatures();
    }
    
    public void deleteFeature(int id) {
    	Optional<Project> project=repository.findById(id);
    	int project_id=project.get().getId();
        List<Features> feature = featureRepository.findByProjectId(project_id);
        featureRepository.deleteAll(feature);
    }
    
    public Features updateFeature(int id, Features feature) {
    	Optional<Features> feature1 = featureRepository.findById(id);
    	Features f=feature1.get();
        f.setDescription(feature.getDescription()); 
        f.setHeading(feature.getHeading()); 
        return featureRepository.save(f);
    }
    
    public List<Features> viewFeatureByProject(int id) {
    	List<Features> feature1 = featureRepository.findAllByProjectId(id);
        return feature1;
    }
    
    public ScreenshotsDTO addScreenshotToProject(String name, ScreenshotsDTO screenshotDTO) throws IOException {
        Project project = repository.findByName(name)
                                    .orElseThrow(() -> new RuntimeException("Project not found"));

        MultipartFile img = screenshotDTO.getImg();
        if (img != null && !img.isEmpty()) {
            byte[] imgBytes = img.getBytes();
            screenshotDTO.setByteimg(imgBytes);
        } else {
            throw new IllegalArgumentException("Image file is required.");
        }
        Screenshots screenshot = new Screenshots();
        screenshot.setImg(screenshotDTO.getByteimg());
        screenshot.setProject(project);
        project.getScreenshots().add(screenshot);
        repository.save(project);
        screenshotDTO.setId(screenshot.getId());
        return screenshotDTO;
    }
    
    public void deleteScreenshotFromProject(int id) {
    	Optional<Project> project=repository.findById(id);
    	int project_id=project.get().getId();
        List<Screenshots> ss = screenshotsRepository.findByProjectId(project_id);
        screenshotsRepository.deleteAll(ss);
    }
    
    public Screenshots updateScreenshot(int id, Screenshots screenshot) {
    	Optional<Screenshots> Screenshot1 = screenshotsRepository.findById(id);
    	Screenshots ss=Screenshot1.get();
        ss.setImg(screenshot.getImg()); 
        return screenshotsRepository.save(ss);
    }
    
    public List<Screenshots> viewScreenshotsByProject(int id) {
    	List<Screenshots> screenshot = screenshotsRepository.findAllByProjectId(id);
        return screenshot;
    }
    
    public List<ScreenshotsDTO> getScreenshotsByProjectId(int projectId) {
        List<Screenshots> screenshots = screenshotsRepository.findByProjectId(projectId);
        return screenshots.stream().map(screenshot -> {
            ScreenshotsDTO dto = new ScreenshotsDTO();
            dto.setId(screenshot.getId());
            byte[] imgData = screenshot.getImg();
            if (imgData != null) {
                String imgBase64 = Base64.getEncoder().encodeToString(imgData);
                dto.setImgBase64(imgBase64);
            }
            return dto;
        }).collect(Collectors.toList());
    }

    
    public List<Features> getFeaturesByProjectId(int projectId) {
        List<Features> features = featureRepository.findByProjectId(projectId);
        return features.stream().map(feature -> {
            Features dto = new Features();
            dto.setId(feature.getId());
            dto.setHeading(feature.getHeading());
            dto.setDescription(feature.getDescription());
            return dto;
        }).collect(Collectors.toList());
    }
}
