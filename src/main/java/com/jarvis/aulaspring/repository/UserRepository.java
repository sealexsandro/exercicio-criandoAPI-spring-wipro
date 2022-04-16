package com.jarvis.aulaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.aulaspring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
