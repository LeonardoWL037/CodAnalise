package com.codanalise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
//    @MapsId
    private Pagamento pagamento;

    @JsonFormat(timezone="America/Recife", pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime hora;

    private long id_mentor;
    private long id_usuario;

    private boolean conf_mentor;

    private boolean conf_usuario;


}
