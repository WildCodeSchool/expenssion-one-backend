package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Race;
import com.example.demo.service.RaceService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/races")
public class RaceController {

  @Autowired
  private RaceService raceService;

  @Operation(summary = "Get all races", description = "Get all races")
  @GetMapping("")
  public List<Race> getAll() {
    return raceService.getAll();
  }

  @Operation(summary = "Get race by id", description = "Get title by id")
  @GetMapping("/{id}")
  public Race getById(@PathVariable Long id) {
    return this.raceService.getById(id);
  }
}
