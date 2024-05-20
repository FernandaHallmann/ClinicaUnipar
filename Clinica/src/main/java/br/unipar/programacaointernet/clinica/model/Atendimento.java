package br.unipar.programacaointernet.clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Atendimento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp data_hora;
    private String anamnese;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;
}
