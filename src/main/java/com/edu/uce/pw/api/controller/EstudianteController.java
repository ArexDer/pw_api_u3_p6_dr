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
	// NIVEL 1  http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(path = "/guardar")
	public void guardad(@RequestBody Estudiante est) {
		this.estudianteService.guardar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/6
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
	
		this.estudianteService.actualizar(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/5

	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);

		this.estudianteService.actualizar(est);

	}

	//Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/8
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
        System.out.println("Borrar");
		this.estudianteService.borrar(id);

	}

	// http://localhost:8082/API/v1.0/Matricula/estudiantes/buscar/5
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		
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
