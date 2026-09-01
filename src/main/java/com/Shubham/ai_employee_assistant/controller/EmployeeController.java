package com.Shubham.ai_employee_assistant.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shubham.ai_employee_assistant.dto.EmployeeRequestDTO;
import com.Shubham.ai_employee_assistant.entity.Employee;
import com.Shubham.ai_employee_assistant.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(
            @Valid @RequestBody EmployeeRequestDTO employeeDTO) {

        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO employeeDTO) {

        return employeeService.updateEmployee(id, employeeDTO);
    }
    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam String keyword) {

        return employeeService.searchEmployees(keyword);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
    
 
}