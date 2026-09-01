package com.Shubham.ai_employee_assistant.service;

import java.util.List;

import com.Shubham.ai_employee_assistant.dto.EmployeeRequestDTO;
import com.Shubham.ai_employee_assistant.entity.Employee;

public interface EmployeeService {

    Employee addEmployee(EmployeeRequestDTO employeeDTO);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, EmployeeRequestDTO employeeDTO);

    void deleteEmployee(Long id);
    
    List<Employee> searchEmployees(String keyword);
}