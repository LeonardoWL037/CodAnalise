package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Proposta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	private long postagem_id;

	private double valor;

	@NotNull @NotEmpty
	private String comentario;

	@Enumerated(EnumType.STRING)
	private PropostaEnum estado;

	@ManyToOne(targetEntity = Mentor.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "mentor_id", referencedColumnName = "id")
	private Mentor mentor;

	@JsonFormat(timezone="America/Recife", pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dt_prop;

}
