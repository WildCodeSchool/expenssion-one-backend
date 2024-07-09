package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BelieveDescription")
public class BeliefContent {

    @Id
    @GeneratedValue
    Long id;
    Integer number;

    @Column(length = 3000)
    private String content;


    @ManyToOne
    @JoinColumn(name = "beliefContent_id")
    private Kingdom kingdom;


    public BeliefContent() {
    }

    

    public BeliefContent(Integer number, String content, Kingdom kingdom) {
        this.number = number;
        this.content = content;
        this.kingdom = kingdom;
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


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Kingdom getKingdom() {
        return kingdom;
    }


    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    

    

    
}
