package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteRepository {

	// CRUD
	public Estudiante seleccionar(Integer id);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);

	public void insertar(Estudiante estudiante);

	List<Estudiante> seleccionarPorGenero(String genero);

	// LISTAR TODOS LOS ESTUDIANTES
	List<Estudiante> seleccionarTodos();

	List<EstudianteTO> seleccionarTodosTO();

}
