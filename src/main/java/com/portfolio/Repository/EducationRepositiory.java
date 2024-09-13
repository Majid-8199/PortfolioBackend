package com.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.Entity.Education;

@Repository
public interface EducationRepositiory extends JpaRepository<Education,Integer>{

}
