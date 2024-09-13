package com.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.Entity.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer>{

}
