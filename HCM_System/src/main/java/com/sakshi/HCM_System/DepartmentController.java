package com.sakshi.HCM_System;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakshi.HCM_System.DeptRepo.DepartmentRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentRepository dept_repo;
	
	//To add Department(save + update)
	@PostMapping("AddDept")
	public Department addDept(@RequestBody Department dept)
	{
		return dept_repo.save(dept);
	}
		
	//get all department data
	@GetMapping("getDept")
	public List<Department> getAllDept(){
		
		return (List<Department>) dept_repo.findAll();
	}
	

	//get department data by dept name
		@GetMapping("/getDept/find/{deptName}")
		public List<Department> getDepartmentByName(@PathVariable String deptName){
			
			return (List<Department>) dept_repo.findByDepartmentName(deptName);
		}
	
	//delete department by id
	@DeleteMapping("/dept/{id}")
	public String deleteDepartment(@PathVariable int id) {
		
		try {
			dept_repo.deleteById(id);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Not OK!";
		}
	}

}
