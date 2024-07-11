package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Kingdom;

@Repository
public interface KingdomRepository  extends JpaRepository<Kingdom, Long> {

} 
