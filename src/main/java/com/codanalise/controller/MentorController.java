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

import com.codanalise.model.Mentor;
import com.codanalise.repository.MentorRepository;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	
	@Autowired
	MentorRepository men;
	
	@GetMapping
	public List<Mentor> listaMentor(){
		return men.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mentor> buscaMentor(@PathVariable Long id){
		Optional<Mentor> mentor = men.findById(id);
		if(mentor.isPresent()) {
			return ResponseEntity.ok(mentor.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/consulta/{usuario_id}")
	public ResponseEntity<Mentor> consultaMentor(@PathVariable Long usuario_id){
		Optional<Mentor> mentor = men.findByUsuarioId(usuario_id);
		if(mentor.isPresent()) {
			return ResponseEntity.ok(mentor.get());
		}else {
			return ResponseEntity.notFound().build();
		}
			
	}
	
//	@GetMapping("/consulta/{usuario_id}")
//	public Mentor consultaMentor(@PathVariable Long usuario_id) {
//		return men.findByUsuarioId(usuario_id);
//	}
	
	
	@PostMapping
	@Transactional
	public Mentor cadastroMentor (@RequestBody Mentor mentor) {
		return men.save(mentor);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Mentor> atualizaMentor(@PathVariable Long id ,@RequestBody Mentor mentor){
		Optional<Mentor> atualizaMentor = men.findById(id);
		if (atualizaMentor.isPresent()) {
			men.save(mentor);
			return ResponseEntity.ok(atualizaMentor.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mentor> deletaMentor(@PathVariable Long id){
		Optional<Mentor> mentor = men.findById(id);
		if(mentor.isPresent()) {
			men.deleteById(id);
			return ResponseEntity.ok(mentor.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
