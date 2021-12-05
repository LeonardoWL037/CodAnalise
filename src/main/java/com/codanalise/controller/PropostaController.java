package com.codanalise.controller;

import com.codanalise.model.Proposta;
import com.codanalise.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

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
		proposta.setDt_prop(LocalDateTime.now(ZoneId.of("America/Recife")));
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
