package com.tka.OrganizationSystem.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDAO;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {
 
	@Autowired
	MainDAO dao;
	
	public String addCountry(Country c) {
		
		String msg = dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg = "Country is not added ";
		}
		
		return msg;
	}

	public String updateCountry(Country c) {
		
		String msg = dao.updateCountry(c);
		if(Objects.isNull(msg)) {
			msg = "Country not updated ...";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		
		String msg = dao.deleteCountry(id);	
		if(Objects.isNull(msg)) {
			msg = "Country is not deleted ";
		}	
		return msg;
	}

	public List<Country> getAllCountry() {

		List<Country> list = dao.getAllCountry();
		
		if(Objects.isNull(list)) {
			list = null;
		}
		
		return list;
	}

	public Country getCountryById(int id) {
		Country c = dao.getCountryById(id);
		
		if(Objects.isNull(c)) {
			c = null;
		}
		
		return c;
	}

	public String addEmployee(Employee emp) {
		
		String msg = dao.addEmployee(emp);
		
		if(Objects.isNull(msg)) {
			msg = "Employee is not added";
		}
		
		
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		List<Employee> list = dao.getAllEmployeee();
		if(Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public String updateEmployee(Employee emp) {
		String msg =  dao.updateEmployee(emp);
		
		if(Objects.isNull(msg)) {
			msg = null;
		}
		
		return msg;
	}

	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		
		if(Objects.isNull(msg)) {
			msg = "Employee not deleted...";
		}
		
		return msg;
	}

	public Employee getEmpById(int id) {
		
		Employee emp = dao.getEmpById(id);
		
		if(Objects.isNull(emp)) {
			emp = null;
		}		
		return emp;
	}
	
}
