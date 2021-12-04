package com.codanalise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Comentarios  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class, orphanRemoval = true)
    private Usuario autorComent;

    @NotNull
    private String comentario;
}
