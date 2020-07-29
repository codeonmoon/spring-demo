package com.adorsys.demo.service;

import java.util.List;

import com.adorsys.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(String name);
	
	public Employee getEmployeeById(Long id);
	
	public Employee createEmployee(Employee newEmployee);
	
	public Employee updateEmployee(Employee newEmployee, Long id);
	
	public void deleteEmployee(Long id);
	
	public List<Employee> getEmployeesByCity(String city);
	
	public List<Employee> getEmployeesByHobby(String hobby);

}
