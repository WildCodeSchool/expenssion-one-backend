package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PrimordialSecret;
import com.example.demo.repository.PrimordialSecretRepository;

@Service
public class PrimordialSecretService {

    @Autowired
    private PrimordialSecretRepository primordialSecretRepository;

    public List<PrimordialSecret> getAll() {
        List<PrimordialSecret> primordialSecrets = this.primordialSecretRepository.findAll();
        return primordialSecrets;
    }

    public PrimordialSecret getById(Long id) {
        PrimordialSecret primordialSecret = this.primordialSecretRepository.findById(id).get();
        return primordialSecret;
    }

}
