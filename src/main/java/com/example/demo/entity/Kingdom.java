package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Kingdom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String urlMap;

    @OneToMany(mappedBy = "kingdom")
    List<Region> regions = new ArrayList<Region>();

    @OneToMany(mappedBy = "kingdom")
    List<Divinity> divinities = new ArrayList<Divinity>();

    @OneToMany(mappedBy = "kingdom")
    List<Belief> believes = new ArrayList<Belief>();
    
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
    public String getUrlMap() {
        return urlMap;
    }
    public void setUrlMap(String urlMap) {
        this.urlMap = urlMap;
    }
    public List<Region> getRegions() {
        return regions;
    }
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
    public List<Divinity> getDivinities() {
        return divinities;
    }
    public void setDivinities(List<Divinity> divinities) {
        this.divinities = divinities;
    }
    public List<Belief> getBelieves() {
        return believes;
    }
    public void setBelieves(List<Belief> believes) {
        this.believes = believes;
    }

    


}
