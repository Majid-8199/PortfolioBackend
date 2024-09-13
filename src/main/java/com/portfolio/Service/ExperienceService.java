package com.portfolio.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Entity.Experience;
import com.portfolio.Repository.ExperienceRepository;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    public Experience addExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(int id, Experience experienceDetails) {
        Experience experience = experienceRepository.findById(id).orElseThrow();
        experience.setCompany(experienceDetails.getCompany());
        experience.setDesignation(experienceDetails.getDesignation());
        experience.setDuration(experienceDetails.getDuration());
        experience.setDescription(experienceDetails.getDescription());
        return experienceRepository.save(experience);
    }

    public void deleteExperience(int id) {
        experienceRepository.deleteById(id);
    }
    
    public Optional<Experience> getExperiencebyId(int id) {
    	return experienceRepository.findById(id);
    }

}
