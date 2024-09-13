package com.portfolio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	Optional<Project> findByName(String name);
}
