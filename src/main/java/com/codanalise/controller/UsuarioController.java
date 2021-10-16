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

import com.codanalise.model.Usuario;
import com.codanalise.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usu;
	
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return usu.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscausuario(@PathVariable long id) {
		Optional<Usuario> usuario = usu.findById(id);
		
		if(usuario.isPresent()) {
			
			return ResponseEntity.ok(usuario.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/login/{email}")
	public ResponseEntity<Usuario> logar(@PathVariable String email ){
		Optional<Usuario> usuario = usu.findByEmail(email);
		if(email == null) {
		 return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(usuario.get());
		}
	}
	
	
	
	@PostMapping
	@Transactional
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usu.save(usuario);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletaUsuario(@PathVariable(value = "id") long id) {
		usu.deleteById(id);
	}
	

	
	
	@PutMapping()
	@Transactional
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usu.save(usuario);
	}
	
}
