package com.example.newschoolapi.controller;

import com.example.newschoolapi.model.Students;
import com.example.newschoolapi.repository.jpql.StudentRepositoryJPQL;
import com.example.newschoolapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

public class StudentController {
    private StudentService service ;
    private StudentRepositoryJPQL repo ;

    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return service.findAll();
    }

    @GetMapping("/jpql/students")
    public List<Students> getAllStudentsJPQL(){
        return repo.findAll();
    }

    @GetMapping("/students/{query}")
    public List<Students> findByNameContent(@PathVariable String query){
        return service.findWhereNameLike(query);
    }

    @PostMapping("/students")
    public Students addStudents(@RequestBody Students s){
        return service.save(s) ;
    }

    @PatchMapping("/students")
    public Students updateStudents(
            @RequestParam("id") Long id,
            @RequestParam("name") String newName
    ){
        return service.update(id, newName);
    }

    @DeleteMapping("students/{id}")
    public String deleteStudents(@PathVariable Long id){
        service.deleteById(id);
        return "Ressource successfully deleted" ;
    }
}
