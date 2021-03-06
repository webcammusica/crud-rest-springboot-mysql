package com.webcammusica.ejercicios.springboot.CRUD.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcammusica.ejercicios.springboot.CRUD.dom.DOMReporte1;


@Service
public class ServicioReporte1 {
	/*
	 * Para la asignación de el resultado de la query se debe crear un DOM de
	 * acuerdo a lo descrito por ejemplo: Reporte1.java, un modelo de objeto
	 * documento o reporte.
	 * https://medium.com/@techkarmo/spring-data-jpa-join-with-unrelated-entities-
	 * with-help-of-jpql-in-spring-boot-application-c358e11512bd
	 * 
	 * https://es.stackoverflow.com/questions/52156/mysql-join-inner-join-3-tablas
	 */

	@Autowired
	EntityManagerFactory emf;

	public List<DOMReporte1> getDOMDomReporte1Query() {
		EntityManager em = emf.createEntityManager();
		// em.getTransaction().begin( );
		Query query = em.createQuery(
				"select new com.webcammusica.ejercicios.springboot.CRUD.dom.DOMReporte1(p.id,p.nombre,c.name) from Factura f INNER JOIN Persona p ON f.id.personaId = p.id INNER JOIN Country c ON f.id.countryId = c.id",
				DOMReporte1.class);
		// @SuppressWarnings("unchecked")
		List<DOMReporte1> list = query.getResultList();

		return list;
	}

	/**
	 * Ejemplo funcional de como crear un query personalizado en JPA
	 * 
	 * @return lista casteada de objetos del tipo del DOM pasado como parámetro.
	 */
	public List<DOMReporte1> getDOMDomReporte1TypedQuery() {

		EntityManager em = emf.createEntityManager();
		// em.getTransaction().begin( );
		TypedQuery<DOMReporte1> query = em.createQuery(
				"select new com.webcammusica.ejercicios.springboot.CRUD.dom.DOMReporte1(p.id,p.nombre,c.name) from Factura f INNER JOIN Persona p ON f.id.personaId = p.id INNER JOIN Country c ON f.id.countryId = c.id",
				DOMReporte1.class);
		// @SuppressWarnings("unchecked")
		List<DOMReporte1> list = query.getResultList();

		return list;

	}
}
