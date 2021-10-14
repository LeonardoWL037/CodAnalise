package com.codanalise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	
	
	@Id
	private long id;
	
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String sobrenome;
	
	@NotNull @NotEmpty
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
	private int perfil;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public Usuario(long id, @NotNull @NotEmpty String nome, @NotNull @NotEmpty String sobrenome,
			@NotNull @NotEmpty String cpf, @NotNull @NotEmpty String genero, @NotNull @NotEmpty String senha,
			@NotNull @NotEmpty String email, String github, String linkedin, @NotNull @NotEmpty int perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.genero = genero;
		this.senha = senha;
		this.email = email;
		this.github = github;
		this.linkedin = linkedin;
		this.perfil = perfil;
	}

	
	
}
