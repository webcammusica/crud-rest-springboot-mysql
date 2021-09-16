package com.webcammusica.ejercicios.springboot.CRUD.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webcammusica.ejercicios.springboot.CRUD.CustomProperties;
import com.webcammusica.ejercicios.springboot.CRUD.servicios.CountryService;
import com.webcammusica.ejercicios.springboot.CRUD.entidades.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La anotación @Controller indica que esta clase es un controlador
 * 
 * @author kumo
 *
 */
@Controller
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	// private final CountryService countryService;
	@Autowired
	private CountryService countryService;

	// private final CustomProperties customProperties;
	@Autowired
	private CustomProperties customProperties;

	/**
	 * El uso de @Autowired ahorra la inicialización
	 * 
	 * @param countryService
	 * @param customProperties
	 */
	public CountryController(CountryService countryService, CustomProperties customProperties) {
		// this.countryService = countryService;
		// this.customProperties = customProperties;
	}

	/**
	 * La anotación @RequestMapping define el URL que escucha la petición procesada
	 * en el método en este caso la raíz "/"
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/")
	public String list(Model model) {
		// logger.info(customProperties.getValue());
		model.addAttribute("countriesList", countryService.findAll());
		return "countriesList";
	}

	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping("output")
	public ModelAndView login1() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	// Se utiliza para recibir parámetros y volver a la página de salida.
	@RequestMapping("input")
	public ModelAndView login2(@RequestParam("yonghu") String yonghu, @RequestParam("mima") String mima) {
		ModelAndView mav = new ModelAndView("output");
		mav.addObject("yonghu", yonghu);
		mav.addObject("mima", mima);

		return mav;
	}
	
	/**
	 * En 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "formAddPais")
	public String agregarProducto(Model model) {
	    model.addAttribute("country", new Country());
	    return "formAddPais";
	}
	
	@RequestMapping("addPais")
	public ModelAndView agregarPais(@RequestParam("name") String name, @RequestParam("population") int population) {
		
		Country newCountry = new Country(name, population);
		countryService.agregarInfoAuditabe(newCountry);
		countryService.insert(newCountry);
		
		ModelAndView mav = new ModelAndView("countriesList");
		mav.addObject("countriesList", countryService.findAll());

		return mav;
	}

}