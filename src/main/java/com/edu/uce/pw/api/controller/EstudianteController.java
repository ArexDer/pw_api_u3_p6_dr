package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

	//Inyectamos la SERVICE
	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar

	// NIVEL 1  http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping()
	public ResponseEntity<Estudiante> guardad(@RequestBody Estudiante est) {
     //Lo mas comun es un OBJETO COMPLETO, para este ejemplo solo un String
		//Si deseo el Estudiante debo consultar el estudiante.
		this.estudianteService.guardar(est);
		return ResponseEntity.status(201).body(est);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/6
	@PatchMapping(path = "/{id}")
	public  ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);

		Estudiante estudiante2 = this.estudianteService.buscar(est.getId());
 
        if (est.getNombre() != null) {
            estudiante2.setNombre(est.getNombre());
        }
        if (est.getApellido() != null) {
            estudiante2.setApellido(est.getApellido());
        }
        if (est.getFechaNacimiento() != null) {
            estudiante2.setFechaNacimiento(est.getFechaNacimiento());
        }
        this.estudianteService.actualizar(estudiante2);
	
		return ResponseEntity.status(239).body(estudiante2);


	}

	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/9

	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);

		this.estudianteService.actualizar(est);
		return ResponseEntity.status(238).body(est);

	}

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/8
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
        System.out.println("Borrar");
		this.estudianteService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");

	}

	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/4
	@GetMapping(path = "/{id}")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {
		//return ResponseEntity.status(236).body(this.estudianteService.buscar(id));
		/*
		 * PARA ENVIAR CABECERA: LO CONTRUYO CONHTTP de SpringFramework.
		 * Las cabeceras se manejan con Clave valor.
		 */
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("Mensaje_236", "Corresponde a la consulta de un RECURSO.");
        cabeceras.add("Valor", "Estudiante Encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id),cabeceras,236);


	}

    // http://localhost:8082/API/v1.0/Matricula/estudiantes/bucarByGenero?genero=F
	//Aqui si se autoriza poner un Path a la capacidad, peron o en infinitivo
	//Aqui si se pone en la CAPACIAD y debe hacer alucion al filtro o funcionalidad.

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=M
	@GetMapping(path = "/genero")
	public List<Estudiante> buscarByGenero(@RequestParam String genero) {
		List<Estudiante> lista = this.estudianteService.buscarPorGenero(genero);
		return lista;
	}


// --------------------------------------------------------------
// USO LOS DOS EL PATH Y REQUEST
	// http://localhost:8082/API/v1.0/Matricula/estudiantes/buscarMixto/5?prueba=HolaMundo

	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/7
	@GetMapping(path = "/mixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("DATO: "+id);
		System.out.println("DATO: "+prueba);

		return this.estudianteService.buscar(id);

	}

	//http://localhost:8080/API/v1.0/Matricula/estudiantes/test/4
	@GetMapping(path = "/test/{id}")
	public Estudiante test(@PathVariable Integer id, @RequestBody Estudiante est){
		System.out.println(est);
		return this.estudianteService.buscar(id);
	}


}
