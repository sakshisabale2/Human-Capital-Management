package com.sakshi.HCM_System;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int dept_id;
	String departmentName;
	String deptHead;
	int No_of_members;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JsonIgnore
    private List<Employees> employees;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int dept_id, String departmentName, String dept_head, int no_of_members, List<Employees> employees) {
		super();
		this.dept_id = dept_id;
		this.departmentName = departmentName;
		this.deptHead = dept_head;
		No_of_members = no_of_members;
		this.employees = employees;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String dept_name) {
		this.departmentName = dept_name;
	}

	public String getDept_head() {
		return deptHead;
	}

	public void setDept_head(String dept_head) {
		this.deptHead = dept_head;
	}

	public int getNo_of_members() {
		return No_of_members;
	}

	public void setNo_of_members(int no_of_members) {
		No_of_members = no_of_members;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + departmentName + ", dept_head=" + deptHead
				+ ", No_of_members=" + No_of_members + ", employees=" + employees + "]";
	}
	
	

}
