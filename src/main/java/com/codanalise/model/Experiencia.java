package com.codanalise.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Experiencia implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private Date dtini;
	
	private Date dtfim;
	
	@NotNull
	private String empresa;
	
	@NotNull
	private String cargo;

//	@Override
//	public String toString() {
//		return "Experiencia [id=" + id + ", dtini=" + dtini + ", dtfim=" + dtfim + ", empresa=" + empresa + "]";
//	}
	
	public Experiencia() {
		
	}

	public Experiencia(long id, Date dtini, Date dtfim, String empresa, String cargo) {
		super();
		this.id = id;
		this.dtini = dtini;
		this.dtfim = dtfim;
		this.empresa = empresa;
		this.cargo = cargo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDtini() {
		return dtini;
	}

	public void setDtini(Date dtini) {
		this.dtini = dtini;
	}

	public Date getDtfim() {
		return dtfim;
	}

	public void setDtfim(Date dtfim) {
		this.dtfim = dtfim;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
	


	
	
}
