package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public City createCity(City city)
    {
        return this.cityRepository.save(city);
    }

    public City UpdateCity(@PathVariable Long id, @RequestBody City city){
        City cityToUpdate = this.cityRepository.findById(id).get();
        cityToUpdate.setName(city.getName());
        cityToUpdate.setUrl(city.getUrl());
        return this.cityRepository.save(cityToUpdate);
    }

    public boolean DeleteCity(@PathVariable Long id){
        this.cityRepository.deleteById(id);
        return true;
    }
}
