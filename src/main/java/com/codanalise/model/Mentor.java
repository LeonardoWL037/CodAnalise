package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Mentor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Base.class)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonView(View.Base.class)
	private Usuario usuario;
	private boolean ativo;

	
	public Mentor() {
		
	}
	
	public Mentor(long id, Usuario usuario, boolean ativo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.ativo = ativo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
