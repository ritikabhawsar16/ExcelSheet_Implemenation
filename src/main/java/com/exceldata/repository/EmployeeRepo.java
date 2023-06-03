package com.exceldata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exceldata.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
