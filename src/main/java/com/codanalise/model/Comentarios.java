package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Comentarios  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class)
    private Usuario autorComent;

    @NotNull
    private String comentario;

    private Long postagem_id;

    @JsonFormat(timezone="America/Recife", pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dt_com;


}
