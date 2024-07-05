package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Divinity;
import com.example.demo.repository.DivinityRepository;

@Service
public class DivinityService {

    @Autowired
    private DivinityRepository divinityRepository;

    public List<Divinity> getAll()
    {
        return this.divinityRepository.findAll();
    }

    public Divinity getById(Long id)
    {
        return this.divinityRepository.findById(id).get();
    }

}
