package com.example.sistemacadastro.repository;

import com.example.sistemacadastro.entity.Estudante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer>  {
    
}
