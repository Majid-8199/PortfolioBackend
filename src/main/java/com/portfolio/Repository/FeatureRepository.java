package com.portfolio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.Entity.Features;
import com.portfolio.Entity.Project;

@Repository
public interface FeatureRepository extends JpaRepository<Features, Integer>{

	List<Features> findByProjectId(int projectId);

	List<Features> findAllByProjectId(int projectId);

}
