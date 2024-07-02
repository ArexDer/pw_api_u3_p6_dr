package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Materia seleccionar(Integer id) {

        return this.entityManager.find(Materia.class, id);
    }

    @Override
    public void actualizar(Materia materia) {

        this.entityManager.merge(materia);

    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.seleccionar(id));

    }

    @Override
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);

    }

    @Override
    public List<Materia> seleccionarPorCantHora(Integer cantHora) {

        TypedQuery<Materia> mQuery = this.entityManager
                .createQuery("SELECT m FROM Materia m WHERE m.cantHora =:cantHora", Materia.class);
        mQuery.setParameter("cantHora", cantHora);
        return mQuery.getResultList();

    }

}
