package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired(required=true)
	private DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> fetchAllDepart() {
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartmentById(Long depId) throws DepartmentNotFoundException {
		Optional<Department> department=departmentRepo.findById(depId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not present");
		}	
		return department.get();
	}

	@Override
	public void deleteByDepId(Long depId) {
		departmentRepo.deleteById(depId);
	}

	@Override
	public Department upadteDepartment(Long depId, Department department) {
		Department depDB= departmentRepo.findById(depId).get();
		if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
			depDB.setName(department.getName());
		}
		if(Objects.nonNull(department.getDepCode()) && !"".equalsIgnoreCase(department.getDepCode())) {
			depDB.setDepCode(department.getDepCode());
		}
		if(Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
			depDB.setAddress(department.getAddress());
		}
		return departmentRepo.save(depDB);
	}

	@Override
	public Department getDepartmentByName(String name) {
		return departmentRepo.findByName(name);
	}

}
