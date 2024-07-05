package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Belief;

public interface BeliefRepository extends JpaRepository<Belief, Long> {
    
}
