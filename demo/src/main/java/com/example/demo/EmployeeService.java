package com.example.demo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
 @Autowired
 MyRepo repo;
 public List<Employee1> displayData()
 {
	return repo.findAll();
 }
public void saveEmployee1(Employee1 employee) {
	
  repo.save(employee);
}
public Employee1 getEmp(long id) {
	
	return repo.findById(id).get();
}
public void delete(long id) {
	repo.deleteById(id);
	
	
	
}
}
