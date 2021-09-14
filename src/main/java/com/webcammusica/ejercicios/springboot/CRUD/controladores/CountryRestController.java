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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

@RestController
@RequestMapping(CountryRestController.COUNTRY_RESOURCE)
public class CountryRestController {

	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(CountryRestController.class);

	/**
	 * Raíz para las llamadas al servicio REST
	 */
	public static final String COUNTRY_RESOURCE = "/api/country";

	/**
	 * @Autowired es equivalente a inicializar en el constructor:
	 *            this.countryService = countryService;
	 */
	@Autowired
	private CountryService countryService;
	

	/**
	 * Método constructor
	 * 
	 * @param countryService
	 */
	public CountryRestController(CountryService countryService) {

	}

	/**
	 * Ejemplo: "http://localhost:9090/countries/api/country/2/". En este ejemplo la
	 * parte del URL que define esta clase es "/api/country" y la que define el
	 * parámetro del método es "/2/". Es indispensable incluir el "/" al final.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}/")
	public ResponseEntity<Country> getById(@PathVariable("id") Long id) {
		Optional<Country> country = countryService.findById(id);
		return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
	}

	/**
	 * Se debe usar una aplicación para el envío de peticiones REST como Postman.
	 * Ejemplo: URL: "http://localhost:9090/países/api/country/". También funciona:
	 * "http://localhost:9090/países/api/country" sin "/" al final. Body de archivo
	 * tipo JSON (en Postman usar opción botón de radio: "raw"): " { "name":
	 * "Germany", "population": 79778000 } "
	 * 
	 * @param country
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Map<String, Object>> add(@RequestBody @Valid Country country) {
		try {
			Long id = countryService.insert(country);
			return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<>(Collections.singletonMap("error", ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Los campos no mapeados son actualizados con "null".
	 * 
	 * @param country
	 * @return
	 */
	@PatchMapping(value = "/partialUpdate", produces = "application/json")
	/*
	 * @RequestMapping(value = "/customers/update", method = RequestMethod.PATCH,
	 * produces = "application/json") es una anotación antigua que hacía lo mismo.
	 */
	public String updateCustomer(Country country) {
		return countryService.patchUpdate(country);
	}

	/*
	 * Este método requiere investigación para determinar la forma de la solicitud
	 * desde Postman por ahora se usa @GetMapping en lugar de @DeleteMapping
	 * 
	 * @DeleteMapping(value = "/delete/{id}/") public ResponseEntity<Country>
	 * deleteById(@PathVariable("id") Long id) { Optional<Country> country =
	 * countryService.delete(id); return country.map(value -> new
	 * ResponseEntity<>(value, HttpStatus.OK)) .orElseGet(() -> new
	 * ResponseEntity<>(null, HttpStatus.NOT_FOUND)); }
	 * 
	 */

	@GetMapping(value = "/delete/{id}/")
	public ResponseEntity<Country> deleteById(@PathVariable("id") Long id) {
		Optional<Country> country = countryService.delete(id);
		return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
	}

	/**
	 * La anotación @RequestMapping define el URL que escucha la petición procesada
	 * en el método en este caso la raíz "/"
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/all")
	public ResponseEntity<List<Country>> list() {
		Optional<List<Country>> country = Optional.ofNullable(countryService.findAll());
		return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
	}

	/**
	 * JSP ./reporte1, usando el repositorio de Country
	 * 
	 * @return
	 */
	@RequestMapping(value = "/reporte1")
	public ModelAndView reportar1() {
		ModelAndView mav = new ModelAndView("reporte1");
		List<Country> paises = countryService.findAll();
		mav.addObject("paises", paises);
		return mav;
	}
	
	/**
	 * JSP usando TypedQuery y no el JPARepository
	 * para comprobar el tipo de objetos que retorna
	 */
	@RequestMapping(value = "/reporte1TQ")
	public ModelAndView reportar1TQ() {
		ModelAndView mav = new ModelAndView("reporte1");
		List<Country> paises = countryService.getDOMDomReporte1();
		mav.addObject("paises", paises);
		return mav;
	}
}