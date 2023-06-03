package com.exceldata.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exceldata.entity.Employee;
import com.exceldata.helper.ExcelHelper;
import com.exceldata.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	public void save(MultipartFile file)
	{
		try 
		{
			List<Employee> emp=ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			this.empRepo.saveAll(emp);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees()
	{
		return this.empRepo.findAll();
	}
}
