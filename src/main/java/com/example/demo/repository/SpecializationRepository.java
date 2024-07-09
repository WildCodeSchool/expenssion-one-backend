package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Specialization;


@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long>{

}
