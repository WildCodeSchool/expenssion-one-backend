package com.example.demo.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "specializationsSkill")
public class SpecializationSkill{
    
    @Id
    @GeneratedValue
    private Long id;

    private Integer number;
    private String name;
    private String description;
    private String characteristic;


    @ManyToOne
    @JoinColumn(name="specializationId",referencedColumnName = "id")
    @JsonBackReference("specialization-specializationSkill")
    private Specialization specialization;

    public SpecializationSkill(){}

    


    public SpecializationSkill(Integer number, String name, String description, String characteristic,
            Specialization specialization) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.characteristic = characteristic;
        this.specialization = specialization;
    }


    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }


    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

 
}

