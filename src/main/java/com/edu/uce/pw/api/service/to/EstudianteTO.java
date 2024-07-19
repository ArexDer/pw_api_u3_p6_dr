package com.edu.uce.pw.api.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

//DEBE TENER EN SU MAYORIA LOS MISMOS CAMPOS DE ESTUDIANTES.
//PERO NO NECESARIAMENTE, LOS CAMPOS QUE QUIERO QUE SEAN USSADOS EN LA CAPACIDAD/CONTROLLER
@Data
@ToString
public class EstudianteTO implements Serializable {
                                    //Implementacion IMPORTANTE

private static final long serialVersionUID = 7085562941894409723L;

    

    private Integer id;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private String genero;
    
	//DE MANERA PROVICIONAL
	private List<MateriaTO> materias;
}
