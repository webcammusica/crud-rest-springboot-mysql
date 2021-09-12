package com.webcammusica.ejercicios.springboot.CRUD.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "personas")
public class Persona extends EntidadAuditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	@NotNull
	private String nombre;
	
	@OneToMany(mappedBy = "persona")
    Set<Factura> facturas;
}
