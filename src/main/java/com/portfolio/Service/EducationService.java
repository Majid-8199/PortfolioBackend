package com.portfolio.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Entity.Education;
import com.portfolio.Repository.EducationRepositiory;

@Service
public class EducationService {

    @Autowired
    private EducationRepositiory repositiory;

    public List<Education> getAllEducation() {
        return repositiory.findAll();
    }

    public Education addEducation(Education education) {
        return repositiory.save(education);
    }

    public Education updateEducation(int id, Education educationDetails) {
    	Education education = repositiory.findById(id).orElseThrow();
    	education.setCollege(educationDetails.getCollege());
        education.setPlace(educationDetails.getPlace());
        education.setDuration(educationDetails.getDuration());
        education.setCourse(educationDetails.getCourse());
        return repositiory.save(education);
    }

    public void deleteEducation(int id) {
    	repositiory.deleteById(id);
    }
    
    public Optional<Education> getEducationbyId(int id) {
    	return repositiory.findById(id);
    }
}
