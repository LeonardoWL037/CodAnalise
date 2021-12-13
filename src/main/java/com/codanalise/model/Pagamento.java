package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    @JoinColumn(name = "proposta_id")
    private Proposta proposta;
    private String nro_cartao;

    private String cdv;

    private double vl_pago;

    private String nome_titular;

    @JsonFormat(pattern = "MM/yyyy")
    @DateTimeFormat(pattern = "MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    private Date validade;

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
