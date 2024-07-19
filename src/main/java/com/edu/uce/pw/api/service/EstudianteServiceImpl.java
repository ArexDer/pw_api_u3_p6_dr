package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;


	/*
	 * METODOS DLE TALLER 33
	 */
	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);
		return convertir(estudiante);
	}

	@Override
	public void borrarPorCedula(String cedula) {
		this.estudianteRepository.eliminarPorCedula(cedula);
	}

	@Override
	public Estudiante buscar(Integer id) {

		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}

	/*
	 * TO
	 */
	public EstudianteTO convertir(Estudiante estu) {

		// RECIBE UN Estudiante Y LO PASA A EstudianteTO
		EstudianteTO estTo = new EstudianteTO();
		estTo.setId(estu.getId());
		estTo.setNombre(estu.getNombre());
		estTo.setApellido(estu.getApellido());
		estTo.setFechaNacimiento(estu.getFechaNacimiento());
		estTo.setGenero(estu.getGenero());
		return estTo;
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {

		Estudiante est = this.estudianteRepository.seleccionar(id);
		return this.convertir(est);
	}

	// DEBER: BUSCAR A TODOS LOS ESTUDIANTES
	@Override
	public List<Estudiante> buscarTodos() {

		return this.estudianteRepository.seleccionarTodos();

	}

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		List<Estudiante> estudiantes = this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> estudianteTOs = new ArrayList<>();

		for (Estudiante estudiante : estudiantes) {
			estudianteTOs.add(convertir(estudiante));
		}
		return estudianteTOs;
	}

}
