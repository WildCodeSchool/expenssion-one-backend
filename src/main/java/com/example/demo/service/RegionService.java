package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

@Service
public class RegionService {
    
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAll()
    {
        return this.regionRepository.findAll();
    }

    public Region getById(Long id)
    {
        return this.regionRepository.findById(id).get();
    }
}