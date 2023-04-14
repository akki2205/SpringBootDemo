package com.employeedata.EmployeeData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeedata.EmployeeData.entity.Employee;
import com.employeedata.EmployeeData.error.EmployeeNotFound;
import com.employeedata.EmployeeData.service.EmployeeService;

import jakarta.validation.Valid;


@RestController

public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/getAll")
	public List<Employee> getAllemployee(){
		List<Employee> allEmp = empService.getAllEmp();
		return allEmp;
		
		
	}
	
	  @PostMapping("/employee")
	    public Employee saveEmployee (@RequestBody Employee employee) {
	      
	        return empService.saveEmployee(employee);
	    }

	    @GetMapping("/employee")
	    public List<Employee> fetchDepartmentList() {
	       
	        return empService.fetchEmployee();
	    }

	    @GetMapping("/employee/{id}")
	    public Employee fetchDepartmentById(@PathVariable("id") Long Id)
	            throws EmployeeNotFound {
	        return empService.fetchEmployeeById(Id);
	    }

	    @DeleteMapping("/employee/{id}")
	    public String deleteDepartmentById(@PathVariable("id") Long Id) {
	    	empService.deleteEmployeeById(Id);
	        return "Department deleted Successfully!!";
	    }
//
//	    @PutMapping("/employee/{id}")
//	    public Employee updateDepartment(@PathVariable("id") Long Id,
//	                                       @RequestBody Employee employee) {
//	        return empService.updateEmployeet(Id,employee);
//	    }


}
