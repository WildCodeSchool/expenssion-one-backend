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

import com.example.demo.entity.City;
import com.example.demo.service.CityService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Operation(summary = "Get all cities", description = "Get all cities")
    @GetMapping("")
    public List<City> getAll() {
        return this.cityService.getAll();
    }

    @Operation(summary = "Get city by id", description = "Get city by id")
    @GetMapping("/{id}")
    public City getById(@PathVariable Long id) {
        return this.cityService.getById(id);
    }

    @PostMapping("")
    public City create(@RequestBody City city){
        return this.cityService.createCity(city);

    }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city){
        return this.cityService.UpdateCity(id, city);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.cityService.DeleteCity(id);
    }
}
