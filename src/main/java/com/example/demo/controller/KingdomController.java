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

import com.example.demo.entity.Kingdom;
import com.example.demo.service.KingdomService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/kingdoms")
public class KingdomController {

    @Autowired
    private KingdomService kingdomService;

    @Operation(summary = "Get all kingdoms", description = "Get all kingdoms")
    @GetMapping("")
    public List<Kingdom> getAll() {
        return this.kingdomService.getAll();
    }

    @Operation(summary = "Get kingdom by id", description = "Get kingdom by id")
    @GetMapping("/{id}")
    public Kingdom getById(@PathVariable Long id) {
        return this.kingdomService.getById(id);
    }

    @PostMapping("")
    public Kingdom create(@RequestBody Kingdom kingdom){
        return this.kingdomService.createKingdom(kingdom);

    }

    @PutMapping("/{id}")
    public Kingdom update(@PathVariable Long id, @RequestBody Kingdom kingdom){
        return this.kingdomService.UpdateKingdom(id, kingdom);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.kingdomService.DeleteKingdom(id);
    }
}