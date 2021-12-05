package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

	@Enumerated(EnumType.STRING)
	private PostagemEnum estado = PostagemEnum.ABERTO;

	//	@JsonFormat(shape=JsonFormat.Shape.STRING,timezone="America/Recife"
	@JsonFormat(timezone="America/Recife", pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime datapostagem = LocalDateTime.now();
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class, orphanRemoval = true)
	private Usuario autor;


	@OneToMany(cascade = CascadeType.ALL, targetEntity = Proposta.class)
	@JoinColumn(name = "postagem_id", referencedColumnName = "id")
	private List<Proposta> propostas = new ArrayList<>();


	@NotNull
	@Size(max = 100)
	private String titulo;

	@NotNull
	@Size(max = 1000)
	private String descricao;

	private double valor;
	@OneToMany(targetEntity = TagsLinguagem.class,cascade =CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "postagem_id", referencedColumnName = "id")
	private List<TagsLinguagem> tags;

	@OneToMany(targetEntity = Comentarios.class,cascade =CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name = "postagem_id", referencedColumnName = "id")
	private List<Comentarios> comentarios;





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
