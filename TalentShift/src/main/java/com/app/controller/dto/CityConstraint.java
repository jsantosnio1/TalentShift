package com.app.controller.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.app.entities.CityValidator;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CityValidator.class) 
public @interface CityConstraint {
    String message() default "Invalid city";  
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}