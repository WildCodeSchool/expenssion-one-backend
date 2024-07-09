package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.City;
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

    public Region createRegion(Region region)
    {
        return this.regionRepository.save(region);
    }

    public Region UpdateRegion(@PathVariable Long id, @RequestBody Region region){
        Region regionToUpdate = this.regionRepository.findById(id).get();
        regionToUpdate.setCities(region.getCities());
        regionToUpdate.setDescription(region.getDescription());
        regionToUpdate.setKingdom(region.getKingdom());
        regionToUpdate.setName(region.getName());
        regionToUpdate.setUrl_map(region.getUrl_map());
        return this.regionRepository.save(regionToUpdate);
    }

    public boolean DeleteRegion(@PathVariable Long id){
        this.regionRepository.deleteById(id);
        return true;
    }
}