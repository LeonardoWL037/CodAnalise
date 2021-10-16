package com.codanalise.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String sobrenome;
	
	@NotNull @NotEmpty @Column(unique = true)
	private String cpf;
	
	@NotNull @NotEmpty
	private String genero;
	
	@NotNull @NotEmpty
	private String senha;
	
	@NotNull @NotEmpty @Column(unique = true)
	private String email;
	
	
	private String github;
	
	
	private String linkedin;
	
	@NotNull @NotEmpty
	private boolean mentor;
	
	private String sobre;
	
	@OneToMany
	private List<Experiencia> exp = new ArrayList<>();
	
	@OneToMany
	private List<Linguagem> linguagem = new ArrayList<>();

	public Usuario() {
		
	}

	
    
}
