package com.employeemanager.controller;

import com.employeemanager.Employee;
import com.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // Home Page:
    @RequestMapping("/")
    public String viewHomePage( Model model){
        List<Employee> employeeList = employeeService.listAll();
        model.addAttribute("listEmployee", employeeList);
        return "index";
    }

    // New employee:
    @RequestMapping("/new")
    public String showNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("newEmployee",employee);

        return "new_employee";
    }

    // Posting data from front-end to DB
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:/";
    }


    //edit request:
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditEmployee(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_employee");
        Employee employee = employeeService.get(id);
        // "newemployee" is the same name to be binded in edit_employee view page
        mav.addObject("newemployee", employee);
        return mav;
    }


    // delete request:
    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id){
        employeeService.delete(id);
        return "redirect:/";
    }



}
