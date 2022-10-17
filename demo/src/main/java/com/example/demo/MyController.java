package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
@Autowired
EmployeeService service;
@RequestMapping("/")
public  String showHome(Model model)
{
	System.out.println("display is called");
	List<Employee1> list=service.displayData();
	for(Employee1 p:list)
	{
		System.out.println(p.getId()+" "+p.getName());
		model.addAttribute("abc", list);

	}
	return "show";
}
	@RequestMapping("/addData")
    public String newData(Model model)
    {
        Employee1 employee= new Employee1();
        model.addAttribute("employee", employee);
        return "add_pro";
    }
    @RequestMapping(value =  "/save" , method = RequestMethod.POST)
    public String saveData(@ModelAttribute("employee") Employee1 employee)
    {
        service.saveEmployee1(employee);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editData(@PathVariable(name = "id") long id)
    {
        ModelAndView view = new ModelAndView("edit_data");
        Employee1 employee = service.getEmp(id);
        view.addObject("employee", employee);
        return view;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteData(@PathVariable(name = "id") long
    		id)
    {
        service.delete(id);
        return "redirect:/";
   
    }
	
}

	


