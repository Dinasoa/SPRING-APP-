package com.example.newschoolapi.service;


import com.example.newschoolapi.model.Students;
import com.example.newschoolapi.repository.StudentRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private StudentRepositoryJPA repository ;

    public List<Students> findAll(){
        return repository.findAll() ;
    }

    public Students save(Students s){
        return repository.save(s);
    }

    public Students update(Long id, String newName){
        Optional<Students> student = repository.findById(id);
        if(student.isPresent()){
            student.get().setName(newName);
            return repository.save(student.get());
        }
        else {
            return null;
        }
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Students> findWhereNameLike(String query){
        return repository.findByNameContaining(query);
    }
}
