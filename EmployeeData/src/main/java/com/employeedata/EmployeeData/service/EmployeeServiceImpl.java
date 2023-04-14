package com.employeedata.EmployeeData.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedata.EmployeeData.entity.Employee;
import com.employeedata.EmployeeData.error.EmployeeNotFound;
import com.employeedata.EmployeeData.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = empRepo.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> fetchEmployee() {
		List<Employee> allEmployee = empRepo.findAll();
		return allEmployee;
	}

	@Override
	public Employee fetchEmployeeById(Long id) throws EmployeeNotFound {
		Optional<Employee> empById = empRepo.findById(id);
		
		if(!empById.isPresent()) {
			throw new EmployeeNotFound("Sorry , could not found the employee with entered Id");
		}
		
		return empById.get();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		empRepo.deleteById(id);
		System.out.println("The employee with the entered ID");
		
	}

//	@Override
//	public Employee updateEmployeet(Long id, Employee employee) {
//		 Employee empUpdate = empRepo.findById(id).get();
//		 if(Objects.nonNull(employee.getFirstName()) &&
//			        !"".equalsIgnoreCase(employee.getFirstName())) {
//			 empUpdate.setFirstName(employee.getFirstName());
//			        }
//
//			        if(Objects.nonNull(employee.getLastName()) &&
//			                !"".equalsIgnoreCase(employee.getLastName())) {
//			        	empUpdate.setLastName(employee.getLastName());
//			        }
//
//			        if(Objects.nonNull(employee.getEmail()) &&
//			                !"".equalsIgnoreCase(employee.getEmail())) {
//			        	empUpdate.setEmail(employee.getEmail());
//			        }
//					return empRepo.save(empUpdate);
//			             
//	}

	@Override
	public List<Employee> getAllEmp() {
		return	empRepo.findAll();
		
	}

	
}
