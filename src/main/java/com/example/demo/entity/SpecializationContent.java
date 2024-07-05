package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SpecializationContent")
public class SpecializationContent {
    
    @Id
    @GeneratedValue
    private Long id;

    private Integer number;

    @Column(length = 1000)
    private String content;


    @ManyToOne
    @JoinColumn(name="specializationId",referencedColumnName = "id")
    @JsonBackReference("specialization-specializationContent")
    private Specialization specialization;

    


    public SpecializationContent() {}

    


    public SpecializationContent(Integer number, String content, Specialization specialization) {
        this.number = number;
        this.content = content;
        this.specialization = specialization;
    }




    public Long getId() {
        return id;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }




    public Specialization getSpecialization() {
        return specialization;
    }




    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    
    

    
} 
