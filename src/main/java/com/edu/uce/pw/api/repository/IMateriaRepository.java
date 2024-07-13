package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {

    // CRUD
    public Materia seleccionar(Integer id);

    public void actualizar(Materia materia);

    public void eliminar(Integer id);

    public void insertar(Materia materia);

    List<Materia> seleccionarPorCantHora(Integer cantHora);

    List<Materia> seleccionarPorIdEstudia(Integer id);

}
