package com.example.sistemacadastro.controller;

import java.util.List;
import java.util.Optional;

import com.example.sistemacadastro.entity.Estudante;
import com.example.sistemacadastro.repository.EstudanteRepository;

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
@RequestMapping("/estudantes")
@CrossOrigin
public class CadastroAlunos {


    // Injeta uma dependencia !!!
    @Autowired
    private EstudanteRepository repo;

    // End Point 1
    // (GET) http://localhost:8080/estudantes
    @GetMapping
    public List <Estudante> getEstudantes(){
        List <Estudante> list = repo.findAll();
        return list;
    }

    // End Point 2
    // (GET) http://localhost:8080/estudantes/{id}
    @GetMapping("{id}")
    public Estudante getEstudante(@PathVariable int id){
        Estudante e = repo.findById(id).get();
        return e;
    }

     // End Point 3
    // Salva um estudante, é necessário passar os dados do estudante
    @PostMapping
    public Estudante salvar(@RequestBody Estudante estudante){
        estudante = repo.save(estudante);
        return estudante;
    }

    // End Point 4
    // Remove um estudante, é necessário passar o id
    @DeleteMapping("{id}")
    public void remover(@PathVariable Integer id){
        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(estudante);
    }

    //EndPoint 5
    //Altera um estudante, é necessário passar os dados do heroi no formato JSON e tambem o id
    @PutMapping("{id}")
    public Estudante alterar(@RequestBody Estudante updateEstudante, @PathVariable Integer id){
        Optional<Estudante> op =  repo.findById(id);
        Estudante estudante = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        estudante.setNome(updateEstudante.getNome());
        repo.save(estudante);
        return estudante;
    }
}
