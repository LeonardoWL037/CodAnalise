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

import com.codanalise.model.Proposta;
import com.codanalise.repository.PropostaRepository;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
	
	@Autowired
	PropostaRepository poprosta;
	
	@GetMapping
	public List<Proposta> listarProposta(){
		return poprosta.findAll();
	}
	
	@GetMapping("/id")
	public ResponseEntity<Proposta> buscarProposta(@PathVariable Long id){
		Optional<Proposta> prop = poprosta.findById(id);
		if (prop.isPresent()) {
			return ResponseEntity.ok(prop.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@Transactional
	public Proposta lancaProposta(@RequestBody Proposta proposta) {
	return poprosta.save(proposta);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Proposta> atualizaProposta(@PathVariable long id, @RequestBody Proposta proposta){
		Optional<Proposta> prop = poprosta.findById(id);
		if(prop.isPresent()) {
			poprosta.save(proposta);
			return ResponseEntity.ok(proposta);
		}else {
			return ResponseEntity.notFound().build();
					
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Proposta> apagaProposta(@PathVariable Long id){
	Optional<Proposta> prop = poprosta.findById(id);
		if(prop.isPresent()){
			poprosta.deleteById(id);
			return ResponseEntity.ok(prop.get());
		}else {
			return ResponseEntity.notFound().build();
		}
			
	}

}
