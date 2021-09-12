package com.webcammusica.ejercicios.springboot.CRUD.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//Debe estar en el servicio
//import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {

    @EmbeddedId
    IdFactura id;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    Country country;

    @ManyToOne
    @MapsId("personaId")
    @JoinColumn(name = "persona_id")
    Persona persona;

    //private List<String> items;
    
    public Factura() {
		// TODO Auto-generated constructor stub
	}

	public IdFactura getId() {
		return id;
	}

	public void setId(IdFactura id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/*
	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
    */
    
}