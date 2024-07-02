package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "race")
public class Race {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private String racialTrait;
  private Integer minAge;
  private Integer maxAge;
  private Integer minHeight;
  private Integer maxHeight;
  private Integer speed;

  public Race() {
  }

  public Race(Long id, String name, String description, String racialTrait, Integer minAge, Integer maxAge,
      Integer minHeight, Integer maxHeight, Integer speed) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.racialTrait = racialTrait;
    this.minAge = minAge;
    this.maxAge = maxAge;
    this.minHeight = minHeight;
    this.maxHeight = maxHeight;
    this.speed = speed;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getRacialTrait() {
    return racialTrait;
  }

  public void setRacialTrait(String racialTrait) {
    this.racialTrait = racialTrait;
  }

  public Integer getMinAge() {
    return minAge;
  }

  public void setMinAge(Integer minAge) {
    this.minAge = minAge;
  }

  public Integer getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(Integer maxAge) {
    this.maxAge = maxAge;
  }

  public Integer getMinHeight() {
    return minHeight;
  }

  public void setMinHeight(Integer minHeight) {
    this.minHeight = minHeight;
  }

  public Integer getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(Integer maxHeight) {
    this.maxHeight = maxHeight;
  }

  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  @ManyToMany
  @JoinTable(name = "race_language", joinColumns = @JoinColumn(name = "race_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
  private List<Language> languages = new ArrayList<>();

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

}