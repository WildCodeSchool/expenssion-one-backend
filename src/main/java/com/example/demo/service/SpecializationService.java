package com.example.demo.service;

import com.example.demo.entity.Specialization;
import com.example.demo.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    public Optional<Specialization> findById(Long id) {
        return specializationRepository.findById(id);
    }

    public Specialization save(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public void deleteById(Long id) {
        specializationRepository.deleteById(id);
    }
}
