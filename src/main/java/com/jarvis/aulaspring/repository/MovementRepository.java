package com.jarvis.aulaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.aulaspring.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Integer> {

}
