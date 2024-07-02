package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Operation(summary = "Get all regions", description = "Get all regions")
    @GetMapping("")
    public List<Region> getAll() {
        return this.regionService.getAll();
    }

    @Operation(summary = "Get region by id", description = "Get region by id")
    @GetMapping("/{id}")
    public Region getById(@PathVariable Long id) {
        return this.regionService.getById(id);
    }
}
