package com.portfolio.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Dto.SkillDTO;
import com.portfolio.Entity.Skill;
import com.portfolio.Repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public List<SkillDTO> getAllSkill() {
    	List<Skill> skills = repository.findAll();
        return skills.stream().map(skill -> {
            SkillDTO dto = skill.getDTO();
            dto.setImgBase64(Base64.getEncoder().encodeToString(skill.getImg()));
            return dto;
        }).collect(Collectors.toList());
    }

    public SkillDTO addSkill(SkillDTO skillDto) throws IOException {
    	Skill skill=new Skill();
    	skill.setName(skillDto.getName());
    	skill.setCategory(skillDto.getCategory());
    	skill.setImg(skillDto.getImg().getBytes());
        return repository.save(skill).getDTO();
    }

    public SkillDTO updateSkill(int id, SkillDTO skill) throws IOException {
    	Skill skill1 = repository.findById(id).orElseThrow();
    	skill1.setCategory(skill.getCategory());
    	skill1.setName(skill.getName());
        return repository.save(skill1).getDTO();
    }

    public void deleteSkill(int id) {
    	repository.deleteById(id);
    }
    
    public SkillDTO getSkillbyId(int id) {
    	Skill skill = repository.findById(id).orElseThrow();
        SkillDTO dto = skill.getDTO();
        dto.setImgBase64(Base64.getEncoder().encodeToString(skill.getImg()));
        return dto;
    }
}
