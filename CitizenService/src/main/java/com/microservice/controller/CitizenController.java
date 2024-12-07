package com.microservice.controller;

import com.microservice.entity.Citizen;
import com.microservice.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/citizenId/{id}")
    public ResponseEntity<?> getCitizen(@PathVariable int id) {
        Optional<Citizen> citizen = citizenService.findById(id);
        return ResponseEntity.ok(citizen.get());
    }

    @PostMapping("/")
    public ResponseEntity<?> saveEntity(@RequestBody Citizen citizen) {
        citizenService.save(citizen);
        return ResponseEntity.ok("Entity save Successfully");
    }

    @GetMapping("byVaccinationCenterId/{vaccinationCenterId}")
    public ResponseEntity<?> getCitizens(@PathVariable int vaccinationCenterId) {
        List<Citizen> citizenList = citizenService.findByVaccinationCenterId(vaccinationCenterId);
        return ResponseEntity.ok(citizenList);
    }
}
