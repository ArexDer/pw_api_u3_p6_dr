package com.edu.uce.pw.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data // DE LOMBOK para mis gettesr y setters gets,sets,equals,hashcode.
@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @Column(name = "mat_id")
    private Integer id;

    @Column(name = "mat_codigo_unico")
    private String codigoUnico;

    @Column(name = "mat_nombre_materia")
    private String nombreMateria;

    @Column(name = "mat_profesor")
    private String profesor;

    @Column(name = "mat_cant_credito")
    private String cantCredito;

    @Column(name = "mat_cant_hora")
    private Integer cantHora;

    // GETTERS Y SETTERS

}
