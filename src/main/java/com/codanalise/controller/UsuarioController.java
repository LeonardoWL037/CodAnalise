package com.codanalise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usu;
	
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return usu.findAll();
		
	}
	
	
	@PostMapping
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usu.save(usuario);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletaUsuario(@PathVariable(value = "id") long id) {
		usu.deleteById(id);
	}
	

	
	
	@PutMapping()
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usu.save(usuario);
	}
	
}
