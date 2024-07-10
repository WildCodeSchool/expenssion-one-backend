package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;

    @ManyToMany(mappedBy = "languages")
    @JsonIgnore
  private List<Race> races = new ArrayList<>();

  public Language() {

  }

  public Language( String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }



  public List<Race> getRaces() {
    return races;
  }

  public void setRaces(List<Race> races) {
    this.races = races;
  }

}
