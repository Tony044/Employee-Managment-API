package com.luv2code.springboot.employeesearch.controller;

import com.luv2code.springboot.employeesearch.entity.Employee;
import com.luv2code.springboot.employeesearch.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){

        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // Get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employees", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("employees", theEmployee);

        // send over to our form

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employees") Employee theEmployee){

        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to the /employees/list
        return "redirect:/employees/list";
    }
}
