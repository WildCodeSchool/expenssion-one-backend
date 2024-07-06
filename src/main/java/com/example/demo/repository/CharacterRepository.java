package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Character;


public interface CharacterRepository extends JpaRepository<Character,Long>{

    // public List<Character> findByUserId(Long id);




}
