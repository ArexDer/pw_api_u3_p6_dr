package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

@RestController
// PATH
@RequestMapping(path = "/estudiantes") // En plural al controlador que representa la ENTIDAD
public class EstudianteController {

	// Inyectamos la SERVICE
	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path = "/guardar")
	public void guardad(@RequestBody Estudiante est) {
		// SIEMPRE ES CORRECTO ENVIAR UN OBJETO
		/*
		 * Estudiante est =new Estudiante();
		 * est.setNombre("Diego");
		 * est.setApellido("Rivas"); //AÑO, MES ,DIA, HORA, MINUTOS
		 * est.setFechaNacimiento(LocalDateTime.of(1997, 01, 8, 12,10));
		 * this.estudianteService.guardar(est);
		 */
		this.estudianteService.guardar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {
		Estudiante est = this.estudianteService.buscar(1);
		est.setNombre("Alexander");

		this.estudianteService.actualizar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar() {
		Estudiante est = this.estudianteService.buscar(1);
		est.setNombre("Alexander");
		est.setApellido("Haro"); // AÑO, MES ,DIA, HORA, MINUTOS
		est.setFechaNacimiento(LocalDateTime.of(2024, 01, 8, 12, 10));
		this.estudianteService.actualizar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	@DeleteMapping(path = "/borrar")
	public void borrar() {
		this.estudianteService.borrar(2);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(2);

	}

	@GetMapping(path = "/bucarByGenero")
	public List<Estudiante> buscarByGenero(@RequestParam String genero) {
		List<Estudiante> lista = this.estudianteService.buscarPorGenero(genero);
		return lista;
	}

}
