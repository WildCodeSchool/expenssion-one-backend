package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column;
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
  @Column(columnDefinition = "TEXT")
  private String description;
  private String racial_trait;
  private Integer min_age;
  private Integer max_age;
  private Integer min_height;
  private Integer max_height;
  private Integer speed;
  private String[] default_languages;
  private Integer number_additional_language;
  private String url;


  
  @ManyToMany
  @JoinTable(name = "race_language", joinColumns = @JoinColumn(name = "race_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
  private Set<Language> languages;

  public Race() {
  }

    public Race(String[] default_languages, String description, Set<Language> languages, Integer max_age, Integer max_height, Integer min_age, Integer min_height, String name, Integer number_additional_language, String racial_trait, Integer speed, String url) {
        this.default_languages = default_languages;
        this.description = description;
        this.languages = languages;
        this.max_age = max_age;
        this.max_height = max_height;
        this.min_age = min_age;
        this.min_height = min_height;
        this.name = name;
        this.number_additional_language = number_additional_language;
        this.racial_trait = racial_trait;
        this.speed = speed;
        this.url = url;
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

  public String getRacial_trait() {
    return racial_trait;
  }

  public void setRacial_trait(String racial_trait) {
    this.racial_trait = racial_trait;
  }

  public Integer getMin_age() {
    return min_age;
  }

  public void setMin_age(Integer min_age) {
    this.min_age = min_age;
  }

  public Integer getMax_age() {
    return max_age;
  }

  public void setMax_age(Integer max_age) {
    this.max_age = max_age;
  }

  public Integer getMin_height() {
    return min_height;
  }

  public void setMin_height(Integer min_height) {
    this.min_height = min_height;
  }

  public Integer getMax_height() {
    return max_height;
  }

  public void setMax_height(Integer max_height) {
    this.max_height = max_height;
  }

  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  public String[] getDefault_languages() {
    return default_languages;
  }

  public void setDefault_languages(String[] default_languages) {
    this.default_languages = default_languages;
  }

  public Integer getNumber_additional_language() {
    return number_additional_language;
  }

  public void setNumber_additional_language(Integer number_additional_language) {
    this.number_additional_language = number_additional_language;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public Set<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(Set<Language> languages) {
    this.languages = languages;
  }

}