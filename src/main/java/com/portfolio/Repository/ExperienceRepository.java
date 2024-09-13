package com.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.Entity.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

}
