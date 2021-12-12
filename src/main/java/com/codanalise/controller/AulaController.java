package com.codanalise.controller;

import com.codanalise.model.Aula;
import com.codanalise.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    AulaRepository ar;


    @GetMapping
    public List<Aula> listarAulas(){
        return ar.findAll();
    }

    @PostMapping
    public Aula cadastraAula(@RequestBody Aula aula){
        aula.setConf_mentor(false);
        aula.setConf_usuario(false);
        aula.setHora((LocalDateTime.now(ZoneId.of("America/Recife"))));
        return ar.save(aula);
    }

    @PutMapping
    public Aula atualizaAula(@RequestBody Aula aula){

       return ar.save(aula);
    }

    @GetMapping("/mentor/{id}")
    public List<Aula> buscaPorMentor(@PathVariable(value = "id") long id){
        return ar.findAulaById_mentor(id);
    }

    @GetMapping("/aluno/{id}")
    public List<Aula> buscaPorAluno(@PathVariable(value = "id") long id){
        return ar.findAulaById_usuario(id);
    }
}
