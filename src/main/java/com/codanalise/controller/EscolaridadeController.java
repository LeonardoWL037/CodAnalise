package com.codanalise.controller;

import com.codanalise.model.Escolaridade;
import com.codanalise.repository.EscolaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/esc")
public class EscolaridadeController {

    @Autowired
    EscolaridadeRepository escolaridadeRepository;

    @GetMapping
    public List<Escolaridade> listarEsc(){
        return escolaridadeRepository.findAll();
    }



    @GetMapping(value ="/{id}")
    public List<Escolaridade> escPorUsuario (@PathVariable Long id){

        return escolaridadeRepository.findByUsuario_id(id);
//        Optional<Escolaridade> escolaridade = escolaridadeRepository.findByUsuario_id(id);
//        if (escolaridade.isPresent()){
//            return ResponseEntity.ok(escolaridade.get());
//        }
//
//        return ResponseEntity.notFound().build();
    }

}
