package com.webcammusica.ejercicios.springboot.CRUD.dom;

public class DOMReporte1 {
	

	private Long idPersona;
	
	private String nombrePersona;
	
	private String pais;
	
	public DOMReporte1() {
		// TODO Auto-generated constructor stub
		
	}
	
	public DOMReporte1(Long idPersona, String nombrePesona, String pais) {
		// TODO Auto-generated constructor stub
		this.idPersona = idPersona;
		this.nombrePersona = nombrePesona;
		this.pais = pais;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}
