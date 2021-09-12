package com.webcammusica.ejercicios.springboot.CRUD.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "countries")
public class Country extends EntidadAuditable {

	/**
	 * Se declaran los campos que tiene la tabla que queremos que mapeé JPA, no
	 * tienen porque ser todos.
	 */

	/**
	 * @Id = llave primaria.
	 * @GeneratedValue = una secuencia que puede generar Hibernate, como en este
	 *                 caso o la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Campo no nulo y único.
	 */
	@Column(nullable = false, unique = true)
	@NotNull
	private String name;

	/**
	 * Campo no nulo, máximo dos mil millones, mínimo uno.
	 */
	@Column(nullable = false)
	@NotNull
	@Min(1)
	@Max(2000000000)
	private Integer population;

	@OneToMany(mappedBy = "country")
	Set<Factura> facturas;

	/**
	 * constructor heredado de EntidadAuditable
	 */
	public Country() {
		super();
	}

	/**
	 * constructor
	 * 
	 * @param name
	 * @param population
	 */
	public Country(String name, Integer population) {
		super();
		this.name = name;
		this.population = population;
	}

	/**
	 * Getters y setters.
	 * 
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

}