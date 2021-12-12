package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Proposta.class, orphanRemoval = true)
    @JoinColumn(name = "id")
    private Proposta proposta;
    private String nro_cartao;

    private String cdv;

    private double vl_pago;

    @JsonFormat(timezone="America/Recife", pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime hora;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class)
    private Usuario aluno;


    @OneToOne(fetch = FetchType.EAGER, targetEntity = Mentor.class)
    private Mentor mentor_pag;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuario_id")
//
//    @JoinColumn(name = "id", table = "mentor")
//    private long mentor_id;

}
