package com.Shubham.ai_employee_assistant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Shubham.ai_employee_assistant.dto.EmployeeRequestDTO;
import com.Shubham.ai_employee_assistant.entity.Employee;
import com.Shubham.ai_employee_assistant.exception.ResourceNotFoundException;
import com.Shubham.ai_employee_assistant.repository.EmployeeRepository;
import com.Shubham.ai_employee_assistant.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(EmployeeRequestDTO employeeDTO) {

        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setDesignation(employeeDTO.getDesignation());

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Employee not found with id: " + id
                    )
                );
    }

    @Override
    public Employee updateEmployee(
            Long id,
            EmployeeRequestDTO employeeDTO) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Employee not found with id: " + id
                    )
                );

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setDepartment(employeeDTO.getDepartment());
        existingEmployee.setDesignation(employeeDTO.getDesignation());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Employee not found with id: " + id
                    )
                );

        employeeRepository.delete(existingEmployee);
    }
    
    @Override
    public List<Employee> searchEmployees(String keyword) {

        return employeeRepository
                .findByNameContainingIgnoreCase(keyword);
    }
}