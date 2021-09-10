package com.webcammusica.ejercicios.springboot.CRUD.repositorios;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Establece el auditor de cada operación
 * @author kumo
 *
 */
@Component
public class CustomAuditorAware implements AuditorAware<String> {
 
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("test");
    }
 
}