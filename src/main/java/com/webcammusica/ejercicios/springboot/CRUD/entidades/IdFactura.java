package com.webcammusica.ejercicios.springboot.CRUD.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdFactura implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "country_id")
	Long countryId;

	@Column(name = "persona_id")
	Long personaId;
	
	public IdFactura() {
		// TODO Auto-generated constructor stub
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
