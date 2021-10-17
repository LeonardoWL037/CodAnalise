package com.codanalise.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codanalise.model.Linguagem;
import com.codanalise.repository.LinguagemRepository;

@RestController
@RequestMapping("/linguagem")
public class LinguagemController {
	
	@Autowired
	LinguagemRepository lin;
	
	@GetMapping
	public List<Linguagem> listaLinguagens(){
		return lin.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Linguagem> buscaLing(@PathVariable Long id){
		Optional<Linguagem> linguagem = lin.findById(id);
		return ResponseEntity.ok(linguagem.get());
		
	}
	
	@PostMapping
	@Transactional
	public Linguagem cadLinguagem(@RequestBody Linguagem linguagem) {
		return lin.save(linguagem);
	}
	
	
	@DeleteMapping
	public ResponseEntity<Linguagem> deletaLinguagem(@PathVariable(value = "id") long id){
		Optional<Linguagem> linguagem = lin.findById(id);
		if(linguagem.isPresent()) {
			return ResponseEntity.ok(linguagem.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	@Transactional
	public Linguagem atualizaLinguagem(@RequestBody Linguagem linguagem) {
		return lin.save(linguagem);
	}

}
