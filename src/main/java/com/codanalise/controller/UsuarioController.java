package com.codanalise.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import com.codanalise.repository.MentorRepository;
import com.codanalise.repository.UsuarioRepository;
import com.google.common.reflect.Parameter;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usu;
	@Autowired
	MentorRepository mentor;
	
	
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
//		usu.save(usuario);
//		long idmentor = usuario.getId();
//		if(usuario.isMentor()) {
//			mentor.save(idmentor);
//		}
		return usu.save(usuario);
		
	}
	
//	@PostMapping
//	@Transactional
//	public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
//		try {
//			usu.save(usuario);
//			return ResponseEntity.ok(usuario);
//		}catch (Exception e) {
//		e.printStackTrace();
//		System.out.println("Cadastro falhou");
//		}
//		return ResponseEntity.badRequest().build();
//		}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletaUsuario(@PathVariable(value = "id") long id) {
		Optional<Usuario> usuario = usu.findById(id);
		if(usuario.isPresent()) {
			usu.deleteById(id);
			return ResponseEntity.ok(usuario.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	

	
	
	@PutMapping()
	@Transactional
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usu.save(usuario);
	}
	
}
