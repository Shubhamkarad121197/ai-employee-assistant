package com.Shubham.ai_employee_assistant.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Shubham.ai_employee_assistant.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	List<Employee>findByNameContainingIgnoreCase(String name);
	
	List<Employee>findByDepartmentIgnoreCase(String department);
	
	List<Employee>findByDesignationIgnoreCase(String designation);
	
	
}
