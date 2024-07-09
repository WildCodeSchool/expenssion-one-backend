package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Divinity;

@Repository
public interface DivinityRepository extends JpaRepository<Divinity, Long> {

}
