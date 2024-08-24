package com.sakshi.HCM_System.EmpRepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sakshi.HCM_System.Department;
import com.sakshi.HCM_System.Employees;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees,Integer>{
	
	public List<Employees> findByDepartment(Department department);

	public Employees findByEmailAndPassword(String email,String password);
}
