package com.codanalise.controller;

import com.codanalise.model.TagsLinguagem;
import com.codanalise.repository.TagsLinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tags")
public class TagsLinguagemController {

    @Autowired
    TagsLinguagemRepository tag;


    @GetMapping
    public List<TagsLinguagem> listarLinguagens() {
        return tag.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity buscarLinguagem(@PathVariable long id) {
        Optional<TagsLinguagem> tags = tag.findById(id);
        if (tags.isPresent()) {
            return ResponseEntity.ok(tags.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public TagsLinguagem salvaTag(@RequestBody TagsLinguagem tagsLinguagem){
        return tag.save(tagsLinguagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaTag(@PathVariable long id){
        Optional<TagsLinguagem> tags = tag.findById(id);
        if (tags.isPresent()){
            tag.deleteById(id);
            return ResponseEntity.ok(tags.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    @Transactional
    public TagsLinguagem atualizaTag(@RequestBody TagsLinguagem tagsLinguagem){
        return tag.save(tagsLinguagem);
    }

}
