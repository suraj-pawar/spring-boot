package com.example.demo.controller;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

import antlr.collections.List;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER= org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment() of DeparmentController class."); 
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public java.util.List<Department> fetchAllDepart(){
		return departmentService.fetchAllDepart();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long depId) throws DepartmentNotFoundException {
		return departmentService.getDepartmentById(depId);
	}
	
	@DeleteMapping("/departments/{id}")
	public void deleteByDepId(@PathVariable("id") Long depId) {
		 departmentService.deleteByDepId(depId);
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long depId, @RequestBody Department department) {
		return departmentService.upadteDepartment(depId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable ("name") String name) {
		return departmentService.getDepartmentByName(name);
	}
}
