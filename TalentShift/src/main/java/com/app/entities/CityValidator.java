package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import com.app.controller.dto.CityConstraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CityValidator implements ConstraintValidator<CityConstraint, String> {

    public static final Set<String> COLOMBIAN_CITIES = new HashSet<>();

    static {
        COLOMBIAN_CITIES.add("Bogotá");
        COLOMBIAN_CITIES.add("Medellín");
        COLOMBIAN_CITIES.add("Cali");
        COLOMBIAN_CITIES.add("Barranquilla");
        COLOMBIAN_CITIES.add("Cartagena");
        COLOMBIAN_CITIES.add("Bucaramanga");
        COLOMBIAN_CITIES.add("Cúcuta");
        COLOMBIAN_CITIES.add("Pereira");
        COLOMBIAN_CITIES.add("Santa Marta");
        COLOMBIAN_CITIES.add("Manizales");
        COLOMBIAN_CITIES.add("Neiva");
        COLOMBIAN_CITIES.add("Ibagué");
        COLOMBIAN_CITIES.add("Armenia");
        COLOMBIAN_CITIES.add("Tunja");
        COLOMBIAN_CITIES.add("Pasto");
        COLOMBIAN_CITIES.add("Valledupar");
        COLOMBIAN_CITIES.add("Quibdó");
        COLOMBIAN_CITIES.add("Montería");
        COLOMBIAN_CITIES.add("Villavicencio");
        COLOMBIAN_CITIES.add("Popayán");
        COLOMBIAN_CITIES.add("Sincelejo");
        COLOMBIAN_CITIES.add("Riohacha");
        COLOMBIAN_CITIES.add("Mocoa");
        COLOMBIAN_CITIES.add("Leticia");
        COLOMBIAN_CITIES.add("San Andrés");
        COLOMBIAN_CITIES.add("Inírida");
        COLOMBIAN_CITIES.add("Yopal");
        COLOMBIAN_CITIES.add("San José del Guaviare");
        COLOMBIAN_CITIES.add("Mitú");
        COLOMBIAN_CITIES.add("Puerto Inírida");
    }

    public boolean isValid(String city, ConstraintValidatorContext context) {
        if (city == null || city.trim().isEmpty()) {
            return false; // 
        }
   
        return COLOMBIAN_CITIES.contains(city.trim());
    }
}