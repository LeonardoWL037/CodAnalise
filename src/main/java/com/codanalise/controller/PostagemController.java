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

import com.codanalise.model.Postagem;
import com.codanalise.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
	
	@Autowired
	PostagemRepository postagemRepo;
	
	@GetMapping
	public List<Postagem> listarPosts(){
		return postagemRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> buscarPostagem(@PathVariable Long id){
		Optional<Postagem> post = postagemRepo.findById(id);
		if(post.isPresent()) {
			return ResponseEntity.ok(post.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	@Transactional
	public Postagem cadPostagem(@RequestBody Postagem postagem) {
		return postagemRepo.save(postagem);
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Postagem> atualizaPostagem(@PathVariable Long id, @RequestBody Postagem postagem){
		Optional<Postagem> post = postagemRepo.findById(id);
		if(post.isPresent()) {
			postagemRepo.save(postagem);
			return ResponseEntity.ok(post.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Postagem> deletarPostagem(@PathVariable Long id){
		Optional<Postagem> post = postagemRepo.findById(id);
		if(post.isPresent()) {
			postagemRepo.deleteById( id);
			return ResponseEntity.ok(post.get());
		}else {
			return ResponseEntity.notFound().build();
			
		}
	}

}
