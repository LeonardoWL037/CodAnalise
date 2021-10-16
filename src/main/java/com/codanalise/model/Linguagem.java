package com.codanalise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Linguagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotEmpty @NotEmpty
	private String ferramenta;
	
	@NotEmpty @NotEmpty
	private String exp_ferramenta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}

	public String getExp_ferramenta() {
		return exp_ferramenta;
	}

	public void setExp_ferramenta(String exp_ferramenta) {
		this.exp_ferramenta = exp_ferramenta;
	}
	
	public Linguagem() {
		
	}

	public Linguagem(long id, @NotEmpty @NotEmpty String ferramenta, @NotEmpty @NotEmpty String exp_ferramenta) {
		super();
		this.id = id;
		this.ferramenta = ferramenta;
		this.exp_ferramenta = exp_ferramenta;
	}

	
	
	
}
