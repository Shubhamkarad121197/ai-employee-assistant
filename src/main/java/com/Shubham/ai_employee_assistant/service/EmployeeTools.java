package com.Shubham.ai_employee_assistant.service;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.Shubham.ai_employee_assistant.entity.Employee;
import com.Shubham.ai_employee_assistant.repository.EmployeeRepository;


@Component
public class EmployeeTools {
	private final EmployeeRepository employeeRepository;

	public EmployeeTools(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	@Tool(description="Get all employees from the employee database")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	
	@Tool(description="Get the total no of Employees in the company")
	public long getEmployeeCount() {
		return employeeRepository.count();
	}
	
	
	@Tool(description="Find Employees by department, Example departments are IT, HR, Sales, Finance.")
	public List<Employee> getEmployeesByDepartment(String department){
		return employeeRepository.findByDepartmentIgnoreCase(department);
		
	}
	
	 @Tool(description = "Find employees by designation. Example designations are Developer, Manager, Software Engineer.")
	    public List<Employee> getEmployeesByDesignation(String designation) {
	        return employeeRepository.findByDesignationIgnoreCase(designation);
	    }

	    @Tool(description = "Find employees by name. Use this when the user asks about a specific employee.")
	    public List<Employee> getEmployeesByName(String name) {
	        return employeeRepository.findByNameContainingIgnoreCase(name);
	    }
}
