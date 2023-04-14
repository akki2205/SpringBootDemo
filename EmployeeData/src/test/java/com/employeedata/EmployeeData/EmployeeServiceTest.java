package com.employeedata.EmployeeData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.employeedata.EmployeeData.entity.Employee;
import com.employeedata.EmployeeData.repository.EmployeeRepo;
import com.employeedata.EmployeeData.service.EmployeeServiceImpl;

@SpringBootTest(classes= {EmployeeServiceTest.class})
public class EmployeeServiceTest {
	
	@Mock
	EmployeeRepo empRepo;
	
	@InjectMocks
	EmployeeServiceImpl empSer;
	
	public List<Employee> list ;

	@Test
	public void test_getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1L, "aksh", "patil", "patilgmail.com", 28));
		list.add(new Employee(2L, "abhay", "patil", "patilgmail.com", 27));
		
		when(empRepo.findAll()).thenReturn(list);
		assertEquals(2, empSer.getAllEmp().size());
		
		
	}
}
