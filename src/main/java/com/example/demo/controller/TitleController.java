package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Title;
import com.example.demo.service.TitleService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Operation(summary = "Get all titles", description = "Get all titles")
    @GetMapping("")
    public List<Title> getAll() {
        return this.titleService.getAll();
    }

    @Operation(summary = "Get title by id", description = "Get title by id")
    @GetMapping("/{id}")
    public Title getById(@PathVariable Long id) {
        return this.titleService.getById(id);
    }
}
