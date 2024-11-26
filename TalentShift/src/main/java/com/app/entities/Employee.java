package com.app.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	 @Id
	 @GeneratedValue
	 private Long id;
	 private String firstName;
	 private String middleName;
	 private String lastName;
	 private String locationCity;
	 private String address;
	 private LocalDate birthDate;
	 private String telephone;
	 private String positionTitle;
	 private LocalDate hireDate;
	 private String email;
	 private Double salary;
	 private Integer timeInPosition;
	 @Enumerated(EnumType.STRING)  
	 private EmployeeStatus status;

}
