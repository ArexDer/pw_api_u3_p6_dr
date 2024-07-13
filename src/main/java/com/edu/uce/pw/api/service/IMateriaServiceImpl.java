package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

import jakarta.persistence.TypedQuery;

@Service
public class IMateriaServiceImpl implements IMateriaService {

    @Autowired
    private IMateriaRepository iMateriaRepository;

    @Override
    public Materia buscar(Integer id) {

        return this.iMateriaRepository.seleccionar(id);

    }

    @Override
    public void actualizar(Materia materia) {
        this.iMateriaRepository.actualizar(materia);
    }

    @Override
    public void borrar(Integer id) {
        this.iMateriaRepository.eliminar(id);

    }

    @Override
    public void guardar(Materia materia) {

        this.iMateriaRepository.insertar(materia);
    }

    @Override
    public List<Materia> buscarPorCantHora(Integer cantHora) {

        return this.iMateriaRepository.seleccionarPorCantHora(cantHora);
    }

    @Override
    public List<MateriaTO> buscarPorIdEstudiante(Integer id) {

        List<Materia> lista = this.iMateriaRepository.seleccionarPorIdEstudia(id);
        List<MateriaTO>listaFinal = new ArrayList<>();

        for(Materia mat:lista){
            listaFinal.add(this.convertir(mat));
        }

        return listaFinal;
        

    }

    private MateriaTO convertir(Materia mat){
        MateriaTO matTO= new MateriaTO();
        matTO.setNombreMateria(matTO.getNombreMateria());
        matTO.setCodigoUnico(matTO.getCodigoUnico());
        matTO.setCantHora(matTO.getCantHora());
        matTO.setProfesor(matTO.getProfesor());
        return matTO;


    }

    

}
