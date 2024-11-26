package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.controller.dto.EmployeeDTO;
import com.app.entities.CityValidator;
import com.app.entities.Employee;
import com.app.service.EmployeeService;

import jakarta.validation.Valid;


@Controller
public class EmployeeViewController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);  
        return "list";
    }
    
    @GetMapping("/employee/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("colombianCities", CityValidator.COLOMBIAN_CITIES);
        return "add_employee";  
    }
    
    @PostMapping("/employee/create")
    public String createEmployee(@ModelAttribute @Valid EmployeeDTO employeeDTO, Model model) {
    	try {
    		Employee createdEmployee = employeeService.saveEmployee(employeeDTO);
    		model.addAttribute("employee", createdEmployee);
    		return "redirect:/employees"; 
    	} catch (Exception e) {
    		model.addAttribute("error", "Failed to create the employee. Please try again.");
    		return "error"; 
    	}
    }
    
    @GetMapping("/employee/view/{id}") 
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee_details"; 
        } else {
            model.addAttribute("error", "Employee not found");
            return "error"; 
        }
    }
    
    @GetMapping("/employee/edit/{id}")
    public String getEmployeeForEdit(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("cities", CityValidator.COLOMBIAN_CITIES);
            return "edit_employee";  
        }
        return "error";
    }


    @PostMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);

        if (updatedEmployee != null) {
            return "redirect:/employees";
        } else {
            return "edit_error"; 
        }
    }
}
