package com.webcammusica.ejercicios.springboot.CRUD.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webcammusica.ejercicios.springboot.CRUD.dom.DOMReporte1;
import com.webcammusica.ejercicios.springboot.CRUD.entidades.Country;
import com.webcammusica.ejercicios.springboot.CRUD.servicios.CountryService;
import com.webcammusica.ejercicios.springboot.CRUD.servicios.ServicioReporte1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(ControladorRestDOMReporte1.REPORTES_RESOURCE)

public class ControladorRestDOMReporte1 {

	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ControladorRestDOMReporte1.class);

	/**
	 * Raíz para las llamadas al servicio REST
	 */
	public static final String REPORTES_RESOURCE = "/api/reportes";

	@Autowired
	private ServicioReporte1 servicioReporte1;

	/**
	 * Método constructor
	 * 
	 * @param servicioReporte1
	 */
	public ControladorRestDOMReporte1(ServicioReporte1 servicioReporte1) {

	}

	@GetMapping("/DOMReporte1")
	public List<DOMReporte1> getQuery() {
		return servicioReporte1.getDOMDomReporte1Query();
	}

	@RequestMapping(value = "/reporte1MavQ")
	public ModelAndView JSPQuery() {
		ModelAndView mav = new ModelAndView("reporte1");
		List<DOMReporte1> tuplasR1 = servicioReporte1.getDOMDomReporte1Query();
		mav.addObject("tuplasR1", tuplasR1);
		return mav;
	}
	
	@RequestMapping(value = "/reporte1MavTQ")
	public ModelAndView JSPTypedQuery() {
		ModelAndView mav = new ModelAndView("reporte1");
		List<DOMReporte1> tuplasR1 = servicioReporte1.getDOMDomReporte1TypedQuery();
		mav.addObject("tuplasR1", tuplasR1);
		return mav;
	}

}