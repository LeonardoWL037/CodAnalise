package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Postagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//	@JsonFormat(shape=JsonFormat.Shape.STRING,timezone="America/Recife"
	@JsonFormat(timezone="America/Recife", pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime datapostagem = LocalDateTime.now();
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class, orphanRemoval = true)
	private Usuario autor;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Proposta.class)
	@JoinColumn(name = "postagem_id", referencedColumnName = "id")
	private List<Proposta> propostas = new ArrayList<>();

	@NotNull
	private String descricao;
	private double valor;
	@OneToMany(targetEntity = TagsLinguagem.class,cascade =CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "postagem_id", referencedColumnName = "id")
	private List<TagsLinguagem> tags;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDatapostagem() {
		return datapostagem;
	}

	public void setDatapostagem(LocalDateTime datapostagem) {
		this.datapostagem = datapostagem;
	}

}
