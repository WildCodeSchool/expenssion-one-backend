package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Title;
import com.example.demo.repository.TitleRepository;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> getAll() {
        List<Title> titles = this.titleRepository.findAll();
        return titles;
    }

    public Title getById(Long id) {
        Title title = this.titleRepository.findById(id).get();
        return title;
    }

}
