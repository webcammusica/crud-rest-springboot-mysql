package com.webcammusica.ejercicios.springboot.CRUD.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcammusica.ejercicios.springboot.CRUD.dom.DOMReporte1;

@Service
public class ServicioReporte1 {
	// Para la asignación de el resultado de la query se debe crear un DOM de
	// acuerdo a lo descrito por ejemplo: Reporte1.java, un modelo de objeto documento o reporte.
	// https://medium.com/@techkarmo/spring-data-jpa-join-with-unrelated-entities-with-help-of-jpql-in-spring-boot-application-c358e11512bd
	/*
	 * public List<StudentDetail> JPQLQuery() { EntityManager em =
	 * emf.createEntityManager(); //em.getTransaction().begin( );
	 * 
	 * Query query = em.createQuery("Select" +"s.rollNumber,s.name,d.departName,"
	 * +"s.age,s.email from StudentEntity s " +
	 * "inner join DepartmentEntity d on s.departmentId=d.departmentId");
	 * 
	 * @SuppressWarnings("unchecked") List<StudentDetail> list
	 * =(List<StudentDetail>)query.getResultList();
	 * System.out.println("Student Name :"); em.close();
	 * 
	 * return list;
	 * 
	 * }
	 */
	// https://es.stackoverflow.com/questions/52156/mysql-join-inner-join-3-tablas
	/*
	 * $query = "SELECT f.date, s.id, s.title, s.rate, s.thumbnail, u.username FROM
	 * favorites AS f INNER JOIN submissions AS s ON f.id_submission = s.id INNER
	 * JOIN users AS u ON f.id_user = u.id WHERE f.id_user = ".$user[0]["id"]."
	 * ORDER BY f.date DESC LIMIT 6";
	 */
	
	@Autowired
    EntityManagerFactory emf;
	
	
	public List<DOMReporte1> getDOMDomReporte1() {
		
		EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin( );
		 Query query = em.createQuery("Select p.id,p.nombre,c.name from Factura f INNER JOIN Persona p ON f.id.personaId = p.id INNER JOIN Country c ON f.id.countryId = c.id");
		 @SuppressWarnings("unchecked")
		 List<DOMReporte1> list=(List<DOMReporte1>)query.getResultList();
		 System.out.println("Student Name :"); em.close();
		 
		 return list;
		
	}
}
