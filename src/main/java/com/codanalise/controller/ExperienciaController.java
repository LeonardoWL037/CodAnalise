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

import com.codanalise.model.Experiencia;
import com.codanalise.repository.ExperienciaRepository;

@RestController
@RequestMapping(value = "/exp")
public class ExperienciaController {
	
	@Autowired
	ExperienciaRepository exp;
	
	
	@GetMapping
	public List<Experiencia> listarExp(){
		return exp.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Experiencia> buscarExp(@PathVariable long id){
		Optional<Experiencia> experiencia = exp.findById(id);
		if(experiencia.isPresent()) {
		return ResponseEntity.ok(experiencia.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
		
		
	@PostMapping
	@Transactional
	public Experiencia cadExp(@RequestBody Experiencia experiencia) {
		return exp.save(experiencia);
		}
	@PutMapping
	public Experiencia atualExp(@RequestBody Experiencia experiencia) {
		return exp.save(experiencia);
		
		
	}
	
	
	@DeleteMapping
	public ResponseEntity<Experiencia> deletarExp(@PathVariable long id){
		Optional<Experiencia> experiencia = exp.findById(id);
		if(experiencia.isPresent()) {
			exp.deleteById(id);
			return ResponseEntity.ok(experiencia.get());
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
		
		
	

}