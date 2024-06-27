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

    @Operation(summary = "Get all anecdotic secrets", description = "Get all anecdotic secrets")
    @GetMapping("")
    public List<PrimordialSecret> getAll() {
        return this.primordialSecretService.getAll();
    }

    @Operation(summary = "Get item by id", description = "Get item by id")
    @GetMapping("/{id}")
    public PrimordialSecret getById(@PathVariable Long id) {
        return this.primordialSecretService.getById(id);
    }

}
