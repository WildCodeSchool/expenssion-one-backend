package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long>{

}
