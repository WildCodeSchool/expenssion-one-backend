package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AnecdoticSecret;

@Repository
public interface AnecdoticSecretRepository extends JpaRepository<AnecdoticSecret, Long> {

}
