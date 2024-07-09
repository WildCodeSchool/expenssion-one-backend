package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("")
    public Region create(@RequestBody Region region){
        return this.regionService.createRegion(region);

    }

    @PutMapping("/{id}")
    public Region update(@PathVariable Long id, @RequestBody Region region){
        return this.regionService.UpdateRegion(id, region);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.regionService.DeleteRegion(id);
    }
}
