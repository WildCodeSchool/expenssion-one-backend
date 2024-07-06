package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Language;
import com.example.demo.service.LanguageService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/languages")
public class LanguageController {

  @Autowired
  private LanguageService languageService;

  @Operation(summary = "Get all languages", description = "Get all languages")
  @GetMapping("")
  public List<Language> getAll() {
    return languageService.getAll();
  }

  @Operation(summary = "Get language by id", description = "Get language by id")
  @GetMapping("/{id}")
  public Language getById(@PathVariable Long id) {
    return this.languageService.getById(id);
  }

}
