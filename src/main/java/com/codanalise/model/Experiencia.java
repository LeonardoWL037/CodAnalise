package com.codanalise.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Experiencia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull @NotEmpty
	private Date dt_ini;
	
	@NotNull @NotEmpty
	private Date dt_fim;
	
	@NotNull
	private String empresa;
	
	public Experiencia() {
		
	}

}
