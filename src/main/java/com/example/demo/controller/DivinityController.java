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

import com.example.demo.entity.Divinity;
import com.example.demo.service.DivinityService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/divinities")
public class DivinityController {

    @Autowired
    private DivinityService divinityService;

    @Operation(summary = "Get all divinities", description = "Get all divinities")
    @GetMapping("")
    public List<Divinity> getAll() {
        return this.divinityService.getAll();
    }

    @Operation(summary = "Get divinity by id", description = "Get divinity by id")
    @GetMapping("/{id}")
    public Divinity getById(@PathVariable Long id) {
        return this.divinityService.getById(id);
    }

    @PostMapping("")
    public Divinity create(@RequestBody Divinity divinity){
        return this.divinityService.createDivinity(divinity);

    }

    @PutMapping("/{id}")
    public Divinity update(@PathVariable Long id, @RequestBody Divinity divinity){
        return this.divinityService.UpdateDivinity(id, divinity);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.divinityService.DeleteDivinity(id);
    }
}
