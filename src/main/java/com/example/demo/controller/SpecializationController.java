package com.example.demo.controller;

import com.example.demo.entity.Specialization;
import com.example.demo.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @GetMapping
    public List<Specialization> getAllSpecializations() {
        return specializationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id) {
        Optional<Specialization> specialization = specializationService.findById(id);
        return specialization.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Specialization createSpecialization(@RequestBody Specialization specialization) {
        return specializationService.save(specialization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@PathVariable Long id, @RequestBody Specialization specializationDetails) {
        Optional<Specialization> specialization = specializationService.findById(id);
        if (specialization.isPresent()) {
            Specialization spec = specialization.get();
            spec.setName(specializationDetails.getName());
            spec.setDescription(specializationDetails.getDescription());
            spec.setStatistics(specializationDetails.getStatistics());
            // Mettre à jour les relations si nécessaire
            Specialization updatedSpecialization = specializationService.save(spec);
            return ResponseEntity.ok(updatedSpecialization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
