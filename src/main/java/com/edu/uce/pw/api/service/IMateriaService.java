package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

public interface IMateriaService {

    // CRUD
    public Materia buscar(Integer id);

    public void actualizar(Materia materia);

    public void borrar(Integer id);

    public void guardar(Materia materia);

    List<Materia> buscarPorCantHora(Integer cantHora);

    List<MateriaTO> buscarPorIdEstudiante(Integer id);



}
