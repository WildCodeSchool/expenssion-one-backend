package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "Character")
public class Character {

   @Id
   @GeneratedValue
   private Long id;

   private Integer age;
   private Integer height;
   private String  biography;
   private String  name;

   private Integer strength;
   private Integer dexterity;
   private Integer constitution;
   private Integer intelligence;
   private Integer wisdom;
   private Integer charisma;
   private Integer armor;
   private Integer addiction;
   private Integer speed;
   private Integer perception;


   @ManyToMany
   @JoinTable(
        name = "character_title",
        joinColumns = @JoinColumn(name = "characterId"),
        inverseJoinColumns = @JoinColumn(name = "titleId")
    )
   private Set<Title> titles;


   @ManyToOne
   @JoinColumn(name="jobId",referencedColumnName = "id")
   private Job additionalJob;

   @ManyToOne
   @JoinColumn(name="languageId",referencedColumnName = "id")
   private Language additionalLanguage;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="anecdoticSecretId",referencedColumnName = "id")
   private AnecdoticSecret anecdoticSecret;

   @ManyToOne
   @JoinColumn(name="primordialSecretId",referencedColumnName = "id")
   private PrimordialSecret primordialSecret;

   @ManyToOne
   @JoinColumn(name="specializationId",referencedColumnName = "id")
   private Specialization specialization;

   @ManyToOne
   @JoinColumn(name="bornCityId",referencedColumnName = "id")
   private City bornCity;

   @ManyToOne
   @JoinColumn(name="liveCityId",referencedColumnName = "id")
   private City liveCity;

   @ManyToOne
   @JoinColumn(name="divinityId",referencedColumnName = "id")
   private Divinity divinity;

   @ManyToOne
   @JoinColumn(name="raceId",referencedColumnName = "id")
   private Race race;


   
   public Character(){}
   
   

   public Character(String name,Integer age, Integer height, String biography, Integer strength, Integer dexterity,
         Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, Integer armor, Integer addiction,
         Integer speed, Integer perception, Set<Title> titles, Job additionalJob, Language additionalLanguage,
         AnecdoticSecret anecdoticSecret, PrimordialSecret primordialSecret, Specialization specialization,
         City bornCity, City liveCity, Divinity divinity, Race race) {
      this.name=name;
      this.age = age;
      this.height = height;
      this.biography = biography;
      this.strength = strength;
      this.dexterity = dexterity;
      this.constitution = constitution;
      this.intelligence = intelligence;
      this.wisdom = wisdom;
      this.charisma = charisma;
      this.armor = armor;
      this.addiction = addiction;
      this.speed = speed;
      this.perception = perception;
      this.titles = titles;
      this.additionalJob = additionalJob;
      this.additionalLanguage = additionalLanguage;
      this.anecdoticSecret = anecdoticSecret;
      this.primordialSecret = primordialSecret;
      this.specialization = specialization;
      this.bornCity = bornCity;
      this.liveCity = liveCity;
      this.divinity = divinity;
      this.race = race;
   }



   public Long getId() {
      return id;
   }


   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public Integer getHeight() {
      return height;
   }

   public void setHeight(Integer height) {
      this.height = height;
   }

   public String getBiography() {
      return biography;
   }

   public void setBiography(String biography) {
      this.biography = biography;
   }

   public Integer getStrength() {
      return strength;
   }

   public void setStrength(Integer strength) {
      this.strength = strength;
   }

   public Integer getDexterity() {
      return dexterity;
   }

   public void setDexterity(Integer dexterity) {
      this.dexterity = dexterity;
   }

   public Integer getConstitution() {
      return constitution;
   }

   public void setConstitution(Integer constitution) {
      this.constitution = constitution;
   }

   public Integer getIntelligence() {
      return intelligence;
   }

   public void setIntelligence(Integer intelligence) {
      this.intelligence = intelligence;
   }

   public Integer getWisdom() {
      return wisdom;
   }

   public void setWisdom(Integer wisdom) {
      this.wisdom = wisdom;
   }

   public Integer getCharisma() {
      return charisma;
   }

   public void setCharisma(Integer charisma) {
      this.charisma = charisma;
   }

   public Integer getArmor() {
      return armor;
   }

   public void setArmor(Integer armor) {
      this.armor = armor;
   }

   public Integer getAddiction() {
      return addiction;
   }

   public void setAddiction(Integer addiction) {
      this.addiction = addiction;
   }

   public Integer getSpeed() {
      return speed;
   }

   public void setSpeed(Integer speed) {
      this.speed = speed;
   }

   public Integer getPerception() {
      return perception;
   }

   public void setPerception(Integer perception) {
      this.perception = perception;
   }

   public Job getAdditionalJob() {
      return additionalJob;
   }

   public void setAdditionalJob(Job additionalJob) {
      this.additionalJob = additionalJob;
   }

   public Language getAdditionalLanguage() {
      return additionalLanguage;
   }

   public void setAdditionalLanguage(Language additionalLanguage) {
      this.additionalLanguage = additionalLanguage;
   }

   public AnecdoticSecret getAnecdoticSecret() {
      return anecdoticSecret;
   }

   public void setAnecdoticSecret(AnecdoticSecret anecdoticSecret) {
      this.anecdoticSecret = anecdoticSecret;
   }

   public PrimordialSecret getPrimordialSecret() {
      return primordialSecret;
   }

   public void setPrimordialSecret(PrimordialSecret primordialSecret) {
      this.primordialSecret = primordialSecret;
   }

   public Specialization getSpecialization() {
      return specialization;
   }

   public void setSpecialization(Specialization specialization) {
      this.specialization = specialization;
   }

   public Set<Title> getTitles() {
      return titles;
   }

   public void setTitles(Set<Title> titles) {
      this.titles = titles;
   }

   public City getBornCity() {
      return bornCity;
   }

   public void setBornCity(City bornCity) {
      this.bornCity = bornCity;
   }

   public City getLiveCity() {
      return liveCity;
   }

   public void setLiveCity(City liveCity) {
      this.liveCity = liveCity;
   }

   public Divinity getDivinity() {
      return divinity;
   }

   public void setDivinity(Divinity divinity) {
      this.divinity = divinity;
   }



   public Race getRace() {
      return race;
   }



   public void setRace(Race race) {
      this.race = race;
   }



   public String getName() {
      return name;
   }



   public void setName(String name) {
      this.name = name;
   }




    
}