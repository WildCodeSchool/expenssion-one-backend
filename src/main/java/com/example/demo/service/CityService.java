package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAll()
    {
        return this.cityRepository.findAll();
    }

    public City getById(Long id)
    {
        return this.cityRepository.findById(id).get();
    }
}
