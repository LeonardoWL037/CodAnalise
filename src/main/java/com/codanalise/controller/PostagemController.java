package com.codanalise.controller;

import com.codanalise.model.Postagem;
import com.codanalise.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
	
	@Autowired
	PostagemRepository postagemRepo;
	
	@GetMapping
	public List<Postagem> listarPosts(){
		return postagemRepo.findAll();
	}

	@GetMapping("/usuario/{id}")
	public List<Postagem> listarPorUsuario(@PathVariable Long id){
		return postagemRepo.findPostagemByAutorId(id);
	}

	@GetMapping("/busca/{texto}")
	public List<Postagem> listaPorTagOuNome(@PathVariable String texto){
		return postagemRepo.findPostagemByTagsLinguagemOrAutorNomeContaining(texto);
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
		postagem.setDatapostagem(LocalDateTime.now(ZoneId.of("America/Recife")));
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
