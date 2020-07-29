package com.adorsys.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adorsys.demo.entity.Employee;
import com.adorsys.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id){
		return service.getEmployeeById(id);
	}
	@GetMapping("/employee/name/{name}")
	public Employee getEmployee(@PathVariable String name){
		return service.getEmployee(name);
	}
	
	@GetMapping("/employee/city/{city}")
	public List<Employee> getEmployeesByCity(@PathVariable String city){
		return service.getEmployeesByCity(city);
	}
	
	@GetMapping("/employee/hobby")
	public List<Employee> getEmployeesByHobby(@RequestParam(defaultValue = "test") String hobby){
		return service.getEmployeesByHobby(hobby);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee newEmployee) {
		return service.createEmployee(newEmployee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return service.updateEmployee(newEmployee, id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
	}
}
