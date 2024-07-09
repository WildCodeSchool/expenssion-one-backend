package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PrimordialSecret;
import com.example.demo.service.PrimordialSecretService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/primordial-secrets")
public class PrimordialSecretController {

    @Autowired
    private PrimordialSecretService primordialSecretService;

    @Operation(summary = "Get all primordial secrets", description = "Get all primordial secrets")
    @GetMapping("/all")
    public List<PrimordialSecret> getAll() {
        return this.primordialSecretService.getAll();
    }

    @Operation(summary = "Get primordial secret by id", description = "Get primordial secret by id")
    @GetMapping("/{id}")
    public PrimordialSecret getById(@PathVariable Long id) {
        return this.primordialSecretService.getById(id);
    }

    @Operation(summary = "Get one random primordial secret", description = "Get one random primordial secret")
    @GetMapping("/random-primordial-secret")
    public Long getRandomPrimordialSecretId() {
        return primordialSecretService.getRandomPrimordialSecretId();
    }

}
