package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Kingdom;
import com.example.demo.repository.KingdomRepository;

@Service
public class KingdomService {

    @Autowired
    private KingdomRepository kingdomRepository;

    public List<Kingdom> getAll()
    {
        return this.kingdomRepository.findAll();
    }

    public Kingdom getById(Long id)
    {
        return this.kingdomRepository.findById(id).get();
    }

}
