package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface MyRepo extends JpaRepository<Employee1, Long>
{
	@Service
	public class EmployeeService
	{
	    @Autowired
	    MyRepo myrepo;
	    public  List<Employee1> displayData()
	    {
	         return myrepo.findAll();
	    }
	    public void saveEmployee1(Employee1 employee)
	    {
	        myrepo.save(employee);
	    }
	    public Employee1 getEmp(long id)
	    {
	        return myrepo.findById(id).get();
	    }
	    public void delete(long id)
	    {
	        myrepo.deleteById(id);
	    }
	}



}
