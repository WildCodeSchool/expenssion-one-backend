package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "specialization")
public class Specialization {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String imageUrl;

    @ManyToMany
    @JoinTable(
        name = "specialization_job",
        joinColumns = @JoinColumn(name = "specializationId"),
        inverseJoinColumns = @JoinColumn(name = "jobId")
    )
    private Set<Job> jobs;

    @OneToMany(mappedBy = "specialization",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("specialization-specializationSkill")
    @JsonProperty("skills")

    private List<SpecializationSkill> specializationSkills;

    
    @OneToMany(mappedBy = "specialization",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("specialization-specializationContent")
    @JsonProperty("contents")
    private List<SpecializationContent> specializationContents;


    public Specialization(){}

    


    public Specialization(String name, String imageUrl, Set<Job> jobs, List<SpecializationSkill> specializationSkills,
        List<SpecializationContent> specializationContents) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.jobs = jobs;
        this.specializationSkills = specializationSkills;
        this.specializationContents = specializationContents;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public List<SpecializationSkill> getSpecializationSkill() {
        return specializationSkills;
    }

    public void setSpecializationSkill(List<SpecializationSkill> specializationSkills) {
        this.specializationSkills = specializationSkills;

    }

    public List<SpecializationContent> getSpecializationContents() {
        return specializationContents;
    }

    public void setSpecializationContents(List<SpecializationContent> specializationContents) {
        this.specializationContents = specializationContents;
    }

     
    
}
    
