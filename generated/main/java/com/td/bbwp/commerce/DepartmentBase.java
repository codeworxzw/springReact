
/**
 *  WARN -  DO NOT MODIFY  - This file is generated by Witchcraftmda. Change Department.java instead
 *  Any changes will be overwritten by the next run of the code generator.
 */

package com.td.bbwp.commerce;

import javax.persistence.*;
import org.witchcraft.base.entity.FileAttachment;
import org.witchcraft.base.entity.BaseEntity;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.IndexColumn;

import javax.validation.constraints.*;

import java.math.BigDecimal;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.witchcraft.base.entity.BaseEntity;

@MappedSuperclass

//@Indexed
//@Analyzer(definition = "entityAnalyzer")

public abstract class DepartmentBase extends BaseEntity {

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OrderBy("id DESC")

	protected List<Employee> employees

			= new ArrayList<Employee>()

	;

	//@Unique(entityName = "com.td.bbwp.commerce.Department", fieldName = "NAME")

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NAME", unique = true)

	protected String name

	;

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {

		return employees;
	}

	public Employee addEmployee(Employee employee) {

		employee.setDepartment((Department) this);

		if (this.employees == null) {
			this.employees = new ArrayList<com.td.bbwp.commerce.Employee>();
		}

		this.employees.add(employee);

		return employee;
	}

	public void addEmployees(List<Employee> employeesToAdd) {
		employeesToAdd.forEach(record -> addEmployee(record));
	}

	@Transient
	public String createListEmployeesAsString() {
		return listAsString(employees);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	@Transient
	//Display name
	public String getDisplayName() {
		try {
			return name;
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

	/*
	public List<List<? extends BaseEntity>> getComposites(){
		List lst = new ArrayList();
		
		return lst;
	}
	*/

}