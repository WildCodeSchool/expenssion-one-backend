package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AnecdoticSecret;
import com.example.demo.service.AnecdoticSecretService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/anecdotic-secrets")
public class AnecdoticSecretController {

    @Autowired
    private AnecdoticSecretService anecdoticSecretService;

    @Operation(summary = "Get all anecdotic secrets", description = "Get all anecdotic secrets")
    @GetMapping("all")
    public List<AnecdoticSecret> getAll() {
        return this.anecdoticSecretService.getAll();
    }

    @Operation(summary = "Get anecdotic secret by id", description = "Get anecdotic secret by id")
    @GetMapping("/{id}")
    public AnecdoticSecret getById(@PathVariable Long id) {
        return this.anecdoticSecretService.getById(id);
    }

    @Operation(summary = "Get one random anecdotic secret", description = "Get one random anecdotic secret")
    @GetMapping("/random-anecdotic-secret")
    public AnecdoticSecret getRandomSecret() {
        return anecdoticSecretService.getRandomAnecdoticSecret();
    }

}
