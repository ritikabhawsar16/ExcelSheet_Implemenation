package com.exceldata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exceldata.entity.Employee;
import com.exceldata.helper.ExcelHelper;
import com.exceldata.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmpController 
{
	@Autowired
	private EmployeeService empService;

	//1st
	@PostMapping("/Employee/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
	{
		if(ExcelHelper.checkExcelFormat(file))
		{
			this.empService.save(file);
			Map<String, String> map=new HashMap<>();
			map.put("message","file is uploaded & data saved is equal to db");
			return ResponseEntity.ok(map);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload Excel");
		
	}
	
	//3rd task completed
	@GetMapping("/Employee")
	public List<Employee> getAllEmployee()
	{
		return this.empService.getAllEmployees();
	}
}
