package com.codanalise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String sobrenome;
	
//	@CPF
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

	@OneToMany(targetEntity = Escolaridade.class,cascade =CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private List<Escolaridade> escolaridade;

	private String status;

}
