package com.exceldata.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private int emp_id;
	
	private String emp_name;
	
	private String emp_address;
	
	private String emp_state;
	
	private int emp_salary;
}
