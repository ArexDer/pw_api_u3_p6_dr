package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {


    /*
     * METODOS DEL TALLER 33
     */
    EstudianteTO buscarPorCedula(String cedula);

    public void borrarPorCedula(String cedula);

    // CRUD
    public Estudiante buscar(Integer id);

    public void actualizar(Estudiante estudiante);

    public void borrar(Integer id);

    public void guardar(Estudiante estudiante);

    List<Estudiante> buscarPorGenero(String genero);

    public EstudianteTO convertir(Estudiante estu);

    public EstudianteTO buscarPorId(Integer id);

    // LISTAR TODOS LOS ESTUDIANTES
    List<Estudiante> buscarTodos();

    List<EstudianteTO> buscarTodosTO();

}
