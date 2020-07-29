package com.adorsys.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.demo.entity.Employee;
import com.adorsys.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployee(String name) {
		for(Employee employee : createEmployees()) {
			if(employee.getName().toLowerCase().contains(name.toLowerCase())) {
				return employee;
			}
		}
		return null;
	}

	private List<Employee> createEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByCity(String city) {
		
		return createEmployees().stream().filter(e -> e.getCity().toLowerCase().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesByHobby(String hobby) {
		
		return createEmployees().stream().filter(e -> e.getHobby().toLowerCase().equalsIgnoreCase(hobby)).collect(Collectors.toList());
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found" + id));
	}

	@Override
	public Employee createEmployee(Employee newEmployee) {
		return repo.save(newEmployee);
	}

	@Override
	public Employee updateEmployee(Employee newEmployee, Long id) {
		return repo.findById(id).map((oldEmployee) -> {
			oldEmployee.setName(newEmployee.getName());
			oldEmployee.setCity(newEmployee.getCity());
			oldEmployee.setHobby(newEmployee.getHobby());
			return repo.save(oldEmployee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repo.save(newEmployee);
		});
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}
}
