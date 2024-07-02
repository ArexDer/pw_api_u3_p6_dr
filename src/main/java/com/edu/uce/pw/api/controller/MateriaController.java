package com.edu.uce.pw.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    // http://localhost:8080/API/v1.0/Matricula/materias/guardar

    @PostMapping(path = "/guardar")
    public void guardad(@RequestBody Materia materia) {

        this.iMateriaService.guardar(materia);

    }

    // http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
    @PatchMapping(path = "/actualizarParcial")
    public void actualizarParcial() {
        Materia materia = this.iMateriaService.buscar(1);
        materia.setProfesor("Juanito Voldemort");

        this.iMateriaService.actualizar(materia);

    }

    // http://localhost:8080/API/v1.0/Matricula/materias/actualizar
    @PutMapping(path = "/actualizar")
    public void actualizar() {
        Materia materia = this.iMateriaService.buscar(1);
        materia.setNombreMateria("Matematica Avanzada");
        materia.setCantHora(5);
        materia.setProfesor("Felipe Guanoluisa");

        this.iMateriaService.actualizar(materia);

    }

    // http://localhost:8080/API/v1.0/Matricula/materias/borrar
    @DeleteMapping(path = "/borrar")
    public void borrar() {
        this.iMateriaService.borrar(1);

    }

    // http://localhost:8080/API/v1.0/Matricula/materias/buscar
    @GetMapping(path = "/buscar")
    public Materia buscar() {
        return this.iMateriaService.buscar(2);

    }

    // http://localhost:8080/API/v1.0/Matricula/materias/buscarPorCantidadHoras
    @GetMapping(path = "/bucarPorCantidadHoras")
    public List<Materia> buscarByGenero(@RequestParam Integer cantHora) {
        List<Materia> lista = this.iMateriaService.buscarPorCantHora(cantHora);
        return lista;
    }

}
