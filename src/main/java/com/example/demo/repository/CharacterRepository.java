package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Character;
import com.example.demo.entity.User;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long>{


    public List<Character> findByUser(User user);

    List<Character> findByUserId(String userUUID);


}
