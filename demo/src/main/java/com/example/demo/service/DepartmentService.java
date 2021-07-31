package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchAllDepart();

	public Department getDepartmentById(Long depId) throws DepartmentNotFoundException;

	public void deleteByDepId(Long depId);

	public Department upadteDepartment(Long depId, Department department);

	public Department getDepartmentByName(String name);

}

