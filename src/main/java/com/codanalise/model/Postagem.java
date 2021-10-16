package com.codanalise.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Postagem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime datapostagem = LocalDateTime.now();
	
	@ManyToOne
	private Usuario autor;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Proposta> propostas = new ArrayList<>();

}
