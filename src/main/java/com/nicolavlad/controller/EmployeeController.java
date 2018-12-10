package com.nicolavlad.controller;

import com.nicolavlad.domain.Employee;
import com.nicolavlad.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public String employees(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "employees";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createEmployee(Employee employee, Model model) {
        employeeService.create(employee);
        employeeService.calculateTaxes(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String deleteById(@PathVariable int id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String generatePaycheckById(@PathVariable int id, Model model) {
        List<Employee> employees = employeeService.getById(id);
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        return "paycheck";
    }

}
