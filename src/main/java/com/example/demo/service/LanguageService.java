package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Language;
import com.example.demo.repository.LanguageRepository;

@Service
public class LanguageService {

  @Autowired
  private LanguageRepository languageRepository;

  public List<Language> getAll() {
    List<Language> languages = this.languageRepository.findAll();
    return languages;
  }

  public Language getById(Long id) {
    Language language = this.languageRepository.findById(id).get();
    return language;
  }
}
