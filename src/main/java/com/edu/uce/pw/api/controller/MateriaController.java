package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
// PATH
@RequestMapping(path = "/materias") // En plural al controlador que representa la ENTIDAD
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    // Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias
    @PostMapping()
    public ResponseEntity<Materia> guardad(@RequestBody Materia materia) {
        this.iMateriaService.guardar(materia);

        return ResponseEntity.status(201).body(materia);

    }

    // Nivel 1 http://localhost:8080/API/v1.0/Matricula/materias/1
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {

        materia.setId(id);
        Materia materia2 = this.iMateriaService.buscar(materia.getId());

        if (materia.getNombreMateria() != null) {
            materia2.setNombreMateria(materia.getNombreMateria());
        }
        if (materia.getProfesor() != null) {
            materia2.setProfesor(materia.getProfesor());
        }
        if (materia.getCodigoUnico() != null) {
            materia2.setCodigoUnico(materia.getCodigoUnico());
        }
        this.iMateriaService.actualizar(materia2);
        return ResponseEntity.status(239).body(materia2);

    }

    // Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias/5
    @PutMapping(path = "/{id}")
    public ResponseEntity<Materia> actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
        materia.setId(id);
        this.iMateriaService.actualizar(materia);

        return ResponseEntity.status(239).body(materia);

    }

    // Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias/1
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> borrar(@PathVariable Integer id) {
        this.iMateriaService.borrar(id);

        return ResponseEntity.status(240).body("Borrado");

    }

    // Nivel 1: http://localhost:8080/API/v1.0/Matricula/materias/1
    @GetMapping(path = "/{id}")
    public ResponseEntity<Materia> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.status(236).body(this.iMateriaService.buscar(id));

    }

    // Nivel 1
    // http://localhost:8080/API/v1.0/Matricula/materias/bucarPorCantidadHoras?cantHora=10
    @GetMapping(path = "/bucarPorCantidadHoras")
    public List<Materia> bucarPorCantidadHoras(@RequestParam Integer cantHora) {
        List<Materia> lista = this.iMateriaService.buscarPorCantHora(cantHora);
        return lista;
    }

}

// ------------------------------------------------------------------------------------

/*
 * @RestController
 * // PATH
 * 
 * @RequestMapping(path = "/materias") // En plural al controlador que
 * representa la ENTIDAD
 * public class MateriaController {
 * 
 * @Autowired
 * private IMateriaService iMateriaService;
 * 
 * // http://localhost:8080/API/v1.0/Matricula/materias/guardar
 * 
 * @PostMapping(path = "/guardar")
 * public void guardad(@RequestBody Materia materia) {
 * 
 * //INSERTANDO UN RECURSO.
 * this.iMateriaService.guardar(materia);
 * 
 * }
 * 
 * // http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
 * 
 * @PatchMapping(path = "/actualizarParcial")
 * public void actualizarParcial() {
 * Materia materia = this.iMateriaService.buscar(1);
 * materia.setProfesor("Juanito Voldemort");
 * 
 * this.iMateriaService.actualizar(materia);
 * 
 * }
 * 
 * // http://localhost:8080/API/v1.0/Matricula/materias/actualizar
 * 
 * @PutMapping(path = "/actualizar")
 * public void actualizar() {
 * Materia materia = this.iMateriaService.buscar(1);
 * materia.setNombreMateria("Matematica Avanzada");
 * materia.setCantHora(5);
 * materia.setProfesor("Felipe Guanoluisa");
 * 
 * this.iMateriaService.actualizar(materia);
 * 
 * }
 * 
 * // http://localhost:8080/API/v1.0/Matricula/materias/borrar
 * 
 * @DeleteMapping(path = "/borrar")
 * public void borrar() {
 * this.iMateriaService.borrar(1);
 * 
 * }
 * 
 * // http://localhost:8080/API/v1.0/Matricula/materias/buscar
 * 
 * @GetMapping(path = "/buscar")
 * 
 * //
 * public Materia buscar() {
 * return this.iMateriaService.buscar(1);
 * 
 * }
 * 
 * // http://localhost:8080/API/v1.0/Matricula/materias/buscarPorCantidadHoras
 * 
 * @GetMapping(path = "/bucarPorCantidadHoras")
 * public List<Materia> buscarByGenero(@RequestParam Integer cantHora) {
 * List<Materia> lista = this.iMateriaService.buscarPorCantHora(cantHora);
 * return lista;
 * }
 * 
 * }
 * 
 */
