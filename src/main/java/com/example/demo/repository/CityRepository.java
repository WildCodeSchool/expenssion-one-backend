package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.City;

@Repository
public interface CityRepository  extends JpaRepository<City, Long> {

} 
