package com.portfolio.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.Entity.Certification;
import com.portfolio.Repository.CertificationRepository;

@Service
public class CertificationService {


    @Autowired
    private CertificationRepository repository;

    public List<Certification> getAllCertification() {
        return repository.findAll();
    }

    public Certification addCertification(Certification certification) {
        return repository.save(certification);
    }

    public Certification updateCertification(int id, Certification certification) {
    	Certification certification1 = repository.findById(id).orElseThrow();
    	certification1.setName(certification.getName());
    	certification1.setCenter(certification.getCenter());
    	certification1.setDuration(certification.getDuration());
        return repository.save(certification1);
    }

    public void deleteCertification(int id) {
        repository.deleteById(id);
    }
    
    public Optional<Certification> getCertificationbyId(int id) {
    	return repository.findById(id);
    }
}
