package com.microservice.service;

import com.microservice.entity.Citizen;
import com.microservice.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public Optional<Citizen> findById(Integer id) {
        return citizenRepository.findById(id);
    }

    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    public Citizen save(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public void delete(Citizen citizen) {
        citizenRepository.delete(citizen);
    }

    public List<Citizen> findByVaccinationCenterId(Integer id) {
        return citizenRepository.findByVaccinationCenterId(id);
    }
}
