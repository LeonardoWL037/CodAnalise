package com.codanalise.controller;

import com.codanalise.model.Escolaridade;
import com.codanalise.repository.EscolaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @PostMapping
    @Transactional
    public Escolaridade salvaEscolaridade (@RequestBody Escolaridade escolaridade){
        return escolaridadeRepository.save(escolaridade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Escolaridade> deletaEscolaridade(@PathVariable(value = "id") long id){
        Optional<Escolaridade> escolaridade = escolaridadeRepository.findById(id);
        if (escolaridade.isPresent()){
            escolaridadeRepository.deleteById(id);
            return ResponseEntity.ok(escolaridade.get());
        }
            return ResponseEntity.notFound().build();

    }

    @PutMapping
    @Transactional
    public Escolaridade atualizaEscolaridade(@RequestBody Escolaridade escolaridade){
        return escolaridadeRepository.save(escolaridade);
    }

}
