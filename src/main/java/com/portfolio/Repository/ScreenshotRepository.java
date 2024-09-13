package com.portfolio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Entity.Screenshots;

public interface ScreenshotRepository extends JpaRepository<Screenshots, Integer>{

	List<Screenshots> findByProjectId(int projectId);

	List<Screenshots> findAllByProjectId(int id);

}
