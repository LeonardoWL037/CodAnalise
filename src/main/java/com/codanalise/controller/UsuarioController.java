package com.codanalise.controller;

import com.codanalise.conversor.UsuarioConversor;
import com.codanalise.dto.UsuarioDTO;
import com.codanalise.dto.UsuarioNomeDTO;
import com.codanalise.model.Mentor;
import com.codanalise.model.Usuario;
import com.codanalise.model.View;
import com.codanalise.repository.MentorRepository;
import com.codanalise.repository.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	MentorController mc;
	@Autowired
	UsuarioRepository usu;
	@Autowired
	MentorRepository mentor;
	@Autowired
	UsuarioConversor conv;

	@Autowired
	MentorRepository mr;
	
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return usu.findAll();
		
	}
	@JsonView(View.Base.class)
	@GetMapping(value = "/busca/{nome}")
	public List<Usuario> listaPorNome(@PathVariable String nome){
		return usu.findAllByNomeLike(nome);

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
		Mentor mentor = new Mentor();
		if (usuario.isMentor()){
			mentor.setUsuario(usuario);
			mentor.setAtivo(true);
			mc.cadastroMentor(mentor);
			return usu.save(usuario);
		}else{

			return usu.save(usuario);
		}
		
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
	

	
	
	@PutMapping
	@Transactional
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		Mentor mentor = new Mentor();
		if (usuario.isMentor() && !mr.findByUsuarioId(usuario.getId()).isPresent()){
			mentor.setUsuario(usuario);
			mentor.setAtivo(true);
			mc.cadastroMentor(mentor);
			return usu.save(usuario);
		}else{

			return usu.save(usuario);
		}

	}


	@GetMapping(value = "/dto")
	public List<UsuarioDTO> listarDTO(){
		List<Usuario> listar = usu.findAll();
		return conv.usuarioParaDTO(listar);
	}

	@GetMapping(value = "/nomeoutag/{texto}")
	public List<Usuario> listarPorNomeOuTag(@PathVariable String texto){

		return usu.findByNomeOrSobrenomeOrLinguagemFerramentaContaining(texto);
	}


}
