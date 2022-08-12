package com.example.newschoolapi.repository;

import com.example.newschoolapi.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoryJPA extends JpaRepository<Students, Long> {
    List<Students> findByNameContaining(String query) ;
}
