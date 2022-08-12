package com.example.newschoolapi.repository.jpql;

import com.example.newschoolapi.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryJPQL extends JpaRepository<Students , Long> {

    @Query("SELECT s from Students s")
    List<Students> findAll();
}
