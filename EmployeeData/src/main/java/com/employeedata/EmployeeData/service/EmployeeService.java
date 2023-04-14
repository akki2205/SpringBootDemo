package com.employeedata.EmployeeData.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeedata.EmployeeData.entity.Employee;
import com.employeedata.EmployeeData.error.EmployeeNotFound;


public interface EmployeeService {
	
	
	   public Employee saveEmployee(Employee employee);

	    public List<Employee> fetchEmployee();

	    public Employee fetchEmployeeById(Long id) throws EmployeeNotFound;

	    public void deleteEmployeeById(Long id);

	  //  public Employee updateEmployeet(Long id, Employee employee);
	    
	    public List<Employee>  getAllEmp();

}
