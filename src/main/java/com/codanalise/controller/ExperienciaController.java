package com.codanalise.controller;

import com.codanalise.model.Experiencia;
import com.codanalise.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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