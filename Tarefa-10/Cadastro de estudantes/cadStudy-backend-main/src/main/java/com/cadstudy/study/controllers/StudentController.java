package com.cadstudy.study.controllers;


import java.util.List;
import java.util.Optional;

import com.cadstudy.study.entity.Student;
import com.cadstudy.study.repository.StudentRpository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRpository repo;

    // End Point 1 (GET)
    
    @GetMapping
    public List<Student> getStudent(){
        
        List<Student> list = repo.findAll();

        return list;
    }
    // End Point 2 (POST)
    @PostMapping

    public Student createStudent(@RequestBody Student student){
        student = repo.save(student);
        return student;
    }

    // End Point 3 (PUT)
    @PutMapping("{id}")
    public Student alterarStudent (@RequestBody Student updateStudent,@PathVariable int id){
        Optional<Student> op = repo.findById(id);
        Student student = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        student.setNome(updateStudent.getNome());
        student.setIdade(updateStudent.getIdade());
        student.setCurso(updateStudent.getCurso());
        student.setCidade(updateStudent.getCidade());
        student.setSemestre(updateStudent.getSemestre());
        student.setEmail(updateStudent.getEmail());
        repo.save(student);
        return student;
    }

    // End Point 4 (DELETE)

    @DeleteMapping("{id}")
    public Student excluir (@PathVariable Integer id){
        Optional<Student> op = repo.findById(id);
        Student student = op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(student);
        return student;
        
    }


}
