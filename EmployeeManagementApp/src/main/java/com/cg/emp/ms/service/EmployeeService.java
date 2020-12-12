package com.cg.emp.ms.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.cg.emp.ms.exceptions.EmployeeNotFoundException;
import com.cg.emp.ms.model.Employeeee;
import com.cg.emp.ms.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Cacheable(value = "abc")
	public List<Employeeee> getAllEmployees() {
		List<Employeeee> employess = repository.findAll();
		System.out.println("Employees");
		return employess;
	}

	public Employeeee getEmployeeById(Long empId) {
		Employeeee employee = null;
		Optional<Employeeee> optionalEmployee = repository.findById(empId);
		if (optionalEmployee.isPresent())
			employee = optionalEmployee.get();
		else
			throw new EmployeeNotFoundException("Employee not Found with the given Id.");
		return employee;
	}

	public List<Employeeee> getEmployeeByName(String LastName) {
		List<Employeeee> empList = repository.findByLastName(LastName);
		Iterator<Employeeee> iterator = empList.iterator();
		if (iterator.next().getLastName().equals(LastName)) {
			return empList;
		} else {
			throw new EmployeeNotFoundException("Employee not Found with the given name.");
		}
	}

	public Employeeee addEmployee(Employeeee employee) {

		Employeeee emp = repository.save(employee);

		return emp;
	}

	public Employeeee updateEmployee(Employeeee employee) {

		Employeeee emp = repository.save(employee);

		return emp;
	}

	public Employeeee deleteEmployee(Long empId) {
		repository.deleteById(empId);
		return getEmployeeById(empId);
	}
	///////Cache methods//////////////////////////
	
	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("abc")));
		return cacheManager;
	}

	
	public String relax(int seconds) {
		System.out.println("Relax for a while...");
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "DoneDonaDone";
	}

}
