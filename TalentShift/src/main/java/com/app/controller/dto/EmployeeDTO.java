package com.app.controller.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.app.entities.EmployeeStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	

	@NotNull(message = "firstName can't be null")
	@NotBlank(message = "firstName can't be empty or only spaces")
	@Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$", message = "First name must contain only letters and spaces")
    private String firstName;
	
	@NotNull(message = "middleName can't be null")
	@NotBlank(message = "middleName can't be empty or only spaces")
	@Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$", message = "Middle name must contain only letters and spaces")
	private String middleName;

    @NotNull(message = "lastName can't be null")
    @NotBlank(message = "lastName can't be empty or only spaces")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$", message = "Last name must contain only letters and spaces")
    private String lastName;

    @NotNull(message = "locationCity can't be null")
    @NotBlank(message = "locationCity can't be empty or only spaces")
    @CityConstraint(message = "Invalid city. Please enter a valid Colombian city")
    private String locationCity;

    @NotNull(message = "address can't be null")
    @Pattern(regexp = "^[a-zA-Z0-9,\\s#-]+(?:[\\s#-]*[a-zA-Z0-9]+)*$", message = "Address is invalid")
    private String address;

    @Past(message = "birthDate must be in the past")
    @NotNull(message = "birthDate cannot be null")
    private LocalDate birthDate;

    @Pattern(regexp = "^[0-9]{10}$", message = "telephone must be a 10-digit number")
    private String telephone;

    @NotNull(message = "positionTitle can't be null")
    @NotBlank(message = "positionTitle can't be empty or only spaces")
    private String positionTitle;

    @PastOrPresent(message = "hireDate must be in the past or present")
    @NotNull(message = "hireDate cannot be null")
    private LocalDate hireDate;

    @Email(message = "email should be valid")
    @NotNull(message = "email cannot be null")
    private String email;

    @Min(value = 0, message = "salary must be a positive number")
    @Max(value = 999999999, message = "Salary exceeds the maximum allowed value")
    @NotNull(message = "salary cannot be null")
    private Double salary;

    @Min(value = 0, message = "timeInPosition must be a positive number")
    @NotNull(message = "timeinposition cannot be null")
    private Integer timeInPosition;
    
    private EmployeeStatus status;
}
