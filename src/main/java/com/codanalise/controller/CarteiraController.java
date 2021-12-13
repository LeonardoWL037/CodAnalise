package com.codanalise.controller;

import com.codanalise.model.Carteira;
import com.codanalise.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    CarteiraRepository cr;

    @GetMapping
    public List<Carteira> listarCarteira(){
        return cr.findAll();
    }

    @GetMapping("/{id}")
    public Carteira buscarCarteira(@PathVariable long id){
        return cr.streamCarteiraByMentor_id(id);
    }

    @PutMapping
    public Carteira atualizaCarteira(@RequestBody Carteira carteira){
        return cr.save(carteira);
    }


}
