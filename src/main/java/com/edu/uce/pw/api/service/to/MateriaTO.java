package com.edu.uce.pw.api.service.to;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;


//IMPORTANTE.
//AQUI NO SE PONE LOS RELACIONAMIENTOS   ONETOMANY, MUCHTOONE....

@Data
@ToString
public class MateriaTO implements Serializable {

    private static final long serialVersionUID = 7085562941894409723L;

    private Integer id;
    private String codigoUnico;
    private String nombreMateria;
    private String profesor;
    private String cantCredito;
    private Integer cantHora;
    
}
