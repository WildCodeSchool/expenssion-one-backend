package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
