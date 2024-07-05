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

import com.example.demo.entity.Belief;
import com.example.demo.entity.Divinity;
import com.example.demo.service.BeliefService;
import com.example.demo.service.DivinityService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/believes")
public class BeliefController {
    @Autowired
    private BeliefService beliefService;

    @GetMapping("")
    public List<Belief> getAll() {
        return this.beliefService.getAll();
    }

    @GetMapping("/{id}")
    public Belief getById(@PathVariable Long id) {
        return this.beliefService.getById(id);
    }

    @PostMapping("")
    public Belief create(@RequestBody Belief belief){
        return this.beliefService.createBelief(belief);

    }

    @PutMapping("/{id}")
    public Belief update(@PathVariable Long id, @RequestBody Belief belief){
        return this.beliefService.UpdateBelief(id, belief);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.beliefService.DeleteBelief(id);
    }
}
