package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Race;
import com.example.demo.repository.RaceRepository;

@Service
public class RaceService {

  @Autowired
  private RaceRepository raceRepository;

  public List<Race> getAll() {
    List<Race> races = this.raceRepository.findAll();
    return races;
  }

  public Race getById(Long id) {
    Race race = this.raceRepository.findById(id).get();
    return race;
  }
}
