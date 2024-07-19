package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;


	/*
	 * IMPLEMENTACION DE METODOS DEL TALLER 33
	 */
	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula= :cedula",Estudiante.class);
		query.setParameter("cedula", cedula);

		return query.getSingleResult();
	}

	@Override
	public void eliminarPorCedula(String cedula) {

		this.entityManager.remove(this.seleccionarPorCedula(cedula));
	}


	 //-----------------------------------------------

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));

	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);

	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {

		TypedQuery<Estudiante> mQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.genero =:genero", Estudiante.class);
		mQuery.setParameter("genero", genero);
		return mQuery.getResultList();
	}

	// SELECCIONAR A TODOS LOS ESTUDIANTES
	@Override
	public List<Estudiante> seleccionarTodos() {

		TypedQuery<Estudiante> mQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e", Estudiante.class);

		return mQuery.getResultList();
	}

	@Override
	public List<EstudianteTO> seleccionarTodosTO() {

		TypedQuery<EstudianteTO> mQuery = this.entityManager
				.createQuery("SELECT e FROM EstudianteT0 e", EstudianteTO.class);

		return mQuery.getResultList();

	}

}