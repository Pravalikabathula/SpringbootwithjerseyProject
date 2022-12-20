package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public interface EmployeeService {

	public abstract Employee createEmployee(Employee employee);

 public abstract void updateEmployee(Employee employee); 

	public abstract Employee getEmployee(Long id);

	public abstract List<Employee> getEmployees();

	public abstract void deleteEmployee(Long id);

	public abstract boolean isEmployeeExist(Long id);

	

	


}
