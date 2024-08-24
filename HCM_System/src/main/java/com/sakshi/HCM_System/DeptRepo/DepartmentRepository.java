package com.sakshi.HCM_System.DeptRepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sakshi.HCM_System.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	 List<Department> findByDepartmentName(String DepartmentName);

}
