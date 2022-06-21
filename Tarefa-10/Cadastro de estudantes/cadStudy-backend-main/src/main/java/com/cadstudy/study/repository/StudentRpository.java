package com.cadstudy.study.repository;

import com.cadstudy.study.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRpository extends JpaRepository<Student,Integer> {
    
}
