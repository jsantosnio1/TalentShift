package com.app.service;

import com.app.controller.dto.EmployeeDTO;
import com.app.entities.Employee;
import com.app.entities.EmployeeStatus;
import com.app.persistence.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
    	EmployeeStatus status = employeeDTO.getStatus() != null ? employeeDTO.getStatus() : EmployeeStatus.ACTIVE;
    	Employee employee = Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .middleName(employeeDTO.getMiddleName())
                .lastName(employeeDTO.getLastName())
                .locationCity(employeeDTO.getLocationCity())
                .address(employeeDTO.getAddress())
                .birthDate(employeeDTO.getBirthDate())
                .telephone(employeeDTO.getTelephone())
                .positionTitle(employeeDTO.getPositionTitle())
                .hireDate(employeeDTO.getHireDate())
                .email(employeeDTO.getEmail())
                .salary(employeeDTO.getSalary())
                .timeInPosition(employeeDTO.getTimeInPosition())
                .status(status)
                .build();
        return this.employeeRepository.save(employee);
    }
    
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
    
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        
        if (employeeDetails.getFirstName() == null || employeeDetails.getFirstName().isEmpty() || !employeeDetails.getFirstName().matches("^[A-Za-záéíóúÁÉÍÓÚñÑ\\\\s]+$")) {
            throw new IllegalArgumentException("First name must contain only letters and spaces");
        }
        if (employeeDetails.getLastName() == null || employeeDetails.getLastName().isEmpty() || !employeeDetails.getLastName().matches("^[A-Za-záéíóúÁÉÍÓÚñÑ\\\\s]+$")) {
            throw new IllegalArgumentException("Last name must contain only letters and spaces");
        }
        if (employeeDetails.getMiddleName() == null || employeeDetails.getMiddleName().isEmpty() || !employeeDetails.getMiddleName().matches("^[A-Za-záéíóúÁÉÍÓÚñÑ\\\\s]+$")) {
            throw new IllegalArgumentException("Middle name must contain only letters and spaces");
        }
        if (employeeDetails.getLocationCity() == null || employeeDetails.getLocationCity().isEmpty()) {
            throw new IllegalArgumentException("Location city cannot be null or empty");
        }
        if (employeeDetails.getAddress() == null || employeeDetails.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (employeeDetails.getBirthDate() == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        } else if (!employeeDetails.getBirthDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date must be in the past");
        }
        if (employeeDetails.getTelephone() == null || employeeDetails.getTelephone().isEmpty()) {
            throw new IllegalArgumentException("Telephone cannot be null or empty");
        }
        if (employeeDetails.getPositionTitle() == null || employeeDetails.getPositionTitle().isEmpty()) {
            throw new IllegalArgumentException("Position title cannot be null or empty");
        }
        if (employeeDetails.getHireDate() == null || employeeDetails.getHireDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Hire date cannot be null");
        }
        if (employeeDetails.getEmail() == null || employeeDetails.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (employeeDetails.getSalary() == null || employeeDetails.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be a positive number");
        }
        if (employeeDetails.getSalary() > 999999999) {
            throw new IllegalArgumentException("Salary exceeds the maximum allowed value");
        }
        if (employeeDetails.getTimeInPosition() == null || employeeDetails.getTimeInPosition() <= 0) {
            throw new IllegalArgumentException("Time in position must be a positive number");
        }
        if (employeeDetails.getStatus() == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        
        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setMiddleName(employeeDetails.getMiddleName());
        existingEmployee.setLocationCity(employeeDetails.getLocationCity());
        existingEmployee.setAddress(employeeDetails.getAddress());
        existingEmployee.setBirthDate(employeeDetails.getBirthDate());
        existingEmployee.setTelephone(employeeDetails.getTelephone());
        existingEmployee.setPositionTitle(employeeDetails.getPositionTitle());
        existingEmployee.setHireDate(employeeDetails.getHireDate());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setSalary(employeeDetails.getSalary());
        existingEmployee.setTimeInPosition(employeeDetails.getTimeInPosition());
        existingEmployee.setStatus(employeeDetails.getStatus()); 

        return employeeRepository.save(existingEmployee);
    }
    
  
    
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
}
