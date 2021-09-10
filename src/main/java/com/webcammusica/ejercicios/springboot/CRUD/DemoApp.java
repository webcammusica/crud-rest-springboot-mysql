package com.webcammusica.ejercicios.springboot.CRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.webcammusica.ejercicios.springboot.CRUD.servicios.CountryService;

/**
 * La anotación @SpringBootApplication aplica las funcionalidades proporcionadas
 * por @Configuration, @EnableAutoConfiguration, @ComponentScan y @EnableWebMvc
 * (esta última si tenemos el starter para Spring MVC en las dependencias).
 * 
 * @author kumo
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(CustomProperties.class)
public class DemoApp extends SpringBootServletInitializer implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DemoApp.class);

	@Autowired
	CountryService countryService;

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class, args);
	}

	/**
	 * selecciona todos los registros de "countries" usando el servicio y muestra el
	 * proceso por consola usando slf4j "countryService" conectado con "@autowired"
	 */
	@Override
	public void run(String... arg0) throws Exception {
		logger.info(String.valueOf(countryService.findAll().size()));
	}

}