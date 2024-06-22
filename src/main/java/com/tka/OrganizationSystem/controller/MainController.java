package com.tka.OrganizationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	MainService service;
	
	
	//first api --------------------------------------
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
		
	String msg = service.addCountry(c);
	
	return msg;
		
	}
	
	
	//second api ------------------------------------
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country c) {
		
		String msg  = service.updateCountry(c);
		
		return msg;
	}
	
	
	//third api--------------------------------------
	@DeleteMapping("/deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		
		
		return msg;
	}
	
	//API 4
	@GetMapping("/getAllCountry")
	public List<Country> getAllCountry(){
		
		List<Country> list = service.getAllCountry();
		
		return list;	
	}
	
	
	//API 5
	@GetMapping("/getCountryById/{id}")
	public Country getCountryById(@PathVariable int id) {
		
		Country c  = service.getCountryById(id);
		
		return c;
	}
	
	
	//API 6
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp) {
		
		String msg = service.addEmployee(emp);
		
		return msg;
	}
	
	//API 7
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee emp) {
		String msg = service.updateEmployee(emp);
		
		return msg;
	}
	
	
	//API 8 
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		
		return msg;
	}
	
	//API 9
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployee(){
       List<Employee> list = service.getAllEmployee();
       
       return list;
		
	}
	
	//API 10
	@GetMapping("/getEmpById/{id}")
	public Employee getEmpById(@PathVariable int id) {
		Employee emp = service.getEmpById(id);
		
		return emp;
	}
	
	
	
	
}
