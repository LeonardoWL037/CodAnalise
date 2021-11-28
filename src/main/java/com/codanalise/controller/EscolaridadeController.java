package com.codanalise.controller;

import com.codanalise.model.Escolaridade;
import com.codanalise.repository.EscolaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/esc")
public class EscolaridadeController {

    @Autowired
    EscolaridadeRepository esc;

    @GetMapping
    public List<Escolaridade> listarEsc(){
        return esc.findAll();
    }
}
