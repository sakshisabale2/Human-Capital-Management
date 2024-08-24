package com.sakshi.HCM_System;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.sakshi.HCM_System.DeptRepo.DepartmentRepository;
import com.sakshi.HCM_System.EmpRepo.EmployeeRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeRepository emp_repo;
	
	
	//To add Employees
	@PostMapping("AddEmp")
	public Employees addEmp(@RequestBody Employees Emp)
	{
		return emp_repo.save(Emp);
	}
	
	//get all employees data (save + update)
	@GetMapping("getEmp")
	public List<Employees> getAllemp(){
		
		return (List<Employees>) emp_repo.findAll();
	}	
	
	//delete  employee by id
	@DeleteMapping("/emp/{emp_id}")
    public Status deleteEmployee(@PathVariable int emp_id) {
        try {
			emp_repo.deleteById(emp_id);
//			return new Status(true);
			
		} catch (Exception e) {
			e.printStackTrace();
//			return new Status(false);
		}
        
        return new Status(true);
    }
	
	//sign in
	@PostMapping("/signIn")
	public Employees signIn(@RequestBody Employees employee) {
		
		return emp_repo.findByEmailAndPassword(employee.getEmail(),employee.getPassword());
	}
	
	//get all employees data by department ID
		@GetMapping("getEmp/department/{dept_id}")
		public List<Employees> getAllemp(@PathVariable int dept_id){
			Department department=new Department();
			department.setDept_id(dept_id);
			
			return (List<Employees>) emp_repo.findByDepartment(department);
		}
	
}
	

