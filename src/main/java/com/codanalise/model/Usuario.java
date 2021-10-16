package com.codanalise.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String sobrenome;
	
//	@NotNull @NotEmpty @Column(unique = true)
//	@Length(min = 11)
//	private String cpf;
	@NotNull
	private Date nascimento;
	
	@NotNull @NotEmpty
	private String genero;
	
	@NotNull @NotEmpty
	private String senha;
	
	@NotNull @NotEmpty @Column(unique = true)
	private String email;
	
	
	private String github;
	
	
	private String linkedin;
	
	@NotNull
	private boolean mentor;
	
	private String sobre;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Experiencia> exp = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Linguagem> linguagem = new ArrayList<>();

	public Usuario() {
		
	}

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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
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

	public boolean isMentor() {
		return mentor;
	}

	public void setMentor(boolean mentor) {
		this.mentor = mentor;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public List<Experiencia> getExp() {
		return exp;
	}

	public void setExp(List<Experiencia> exp) {
		this.exp = exp;
	}

	public List<Linguagem> getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(List<Linguagem> linguagem) {
		this.linguagem = linguagem;
	}

	public Usuario(long id, @NotNull @NotEmpty String nome, @NotNull @NotEmpty String sobrenome,
			@NotNull Date nascimento, @NotNull @NotEmpty String genero, @NotNull @NotEmpty String senha,
			@NotNull @NotEmpty String email, String github, String linkedin, @NotNull boolean mentor, String sobre,
			List<Experiencia> exp, List<Linguagem> linguagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nascimento = nascimento;
		this.genero = genero;
		this.senha = senha;
		this.email = email;
		this.github = github;
		this.linkedin = linkedin;
		this.mentor = mentor;
		this.sobre = sobre;
		this.exp = exp;
		this.linguagem = linguagem;
	}

	
	
	
	
    
}
