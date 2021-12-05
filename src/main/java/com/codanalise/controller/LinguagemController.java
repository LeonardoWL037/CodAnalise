package com.codanalise.controller;

import com.codanalise.model.Linguagem;
import com.codanalise.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
