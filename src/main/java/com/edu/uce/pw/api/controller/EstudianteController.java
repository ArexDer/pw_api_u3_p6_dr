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

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/{id}
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
        System.out.println("Borrar");
		this.estudianteService.borrar(id);

	}

	// http://localhost:8082/API/v1.0/Matricula/estudiantes/buscar/5/nuevo/prueba
	@GetMapping(path = "/buscar/{id}/nuevo/{dato}")
	public Estudiante buscar(@PathVariable Integer id,@PathVariable String dato) {
		System.out.println("DATO: "+dato);
		return this.estudianteService.buscar(id);

	}

    // http://localhost:8082/API/v1.0/Matricula/estudiantes/bucarByGenero?genero=F&edad=27
	@GetMapping(path = "/bucarByGenero")
	public List<Estudiante> buscarByGenero(@RequestParam String genero,@RequestParam Integer edad) {
		System.out.println("Edad:"+edad);
		List<Estudiante> lista = this.estudianteService.buscarPorGenero(genero);
		return lista;
	}


// --------------------------------------------------------------
// USO LOS DOS EL PATH Y REQUEST
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/buscarMixto/5?prueba=HolaMundo
	@GetMapping(path = "/buscarMixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("DATO: "+id);
		System.out.println("DATO: "+prueba);

		return this.estudianteService.buscar(id);

	}





}
