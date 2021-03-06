package com.codanalise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
public class Escolaridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instituicao;

    private String nivel;

    private LocalDate dtini;

    private LocalDate dtfim;

    private Long usuario_id;
}