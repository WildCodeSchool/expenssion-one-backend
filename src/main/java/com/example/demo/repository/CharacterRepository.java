package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Character;
import com.example.demo.entity.User;


public interface CharacterRepository extends JpaRepository<Character,Long>{

    public List<Character> findByUser(User user);






}
