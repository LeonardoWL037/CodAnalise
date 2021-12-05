package com.codanalise.controller;

import com.codanalise.model.Comentarios;
import com.codanalise.model.Usuario;
import com.codanalise.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/com")
public class ComentariosController implements Serializable {

    @Autowired
    ComentariosRepository comRep;

    @GetMapping
    public List<Comentarios> listarCom(){
        return comRep.findAll();
    }

    @PostMapping
    public Comentarios postarComentario(@RequestBody Comentarios comentario){
        comentario.setDt_com(LocalDateTime.now());
        return comRep.save(comentario);
    }

    @DeleteMapping(value = "/deletar/{id}")
        public ResponseEntity<Comentarios> deletaComentario ( @PathVariable(value = "id") long id){
            Optional<Comentarios> comentario = comRep.findById(id);
            if (comentario.isPresent()) {
                comRep.deleteById(id);
                return ResponseEntity.ok(comentario.get());
            } else {
                return ResponseEntity.notFound().build();
            }

        }

    @PutMapping
    public ResponseEntity<Comentarios> atualizaComentario(@RequestBody Comentarios comentarios){
        if (comRep.findById(comentarios.getId()).isPresent()){

            return new ResponseEntity<Comentarios>(comRep.save(comentarios), HttpStatus.OK) ;
        }else{
            return new ResponseEntity<Comentarios>(HttpStatus.BAD_REQUEST);
        }
    }

    }