package com.codanalise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	@GetMapping("/id")
//	public ResponseEntity<Proposta> buscarProposta(@PathVariable Long id){
//		Optional<Proposta> prop = poprosta.findById(id);
//		if (prop.isPresent()) {
//			return ResponseEntity.ok(prop.get());
//		}
//	}

}
