/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.controllers;

import com.employeeappraisal.models.Employee;
import com.employeeappraisal.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Euan
 */
@Controller
public class AdminController {
    @Autowired
    private EmployeeService employeeService;
@GetMapping("/admin")
public ModelAndView viewHROverview (Model model){
    ModelAndView mv = new ModelAndView();
    Employee employee = new Employee();
    List<Employee> lineManagers  = employeeService.getAllEmployees(); 
    mv.addObject("employee", employee);
    mv.addObject("linemanagers",lineManagers);
    mv.setViewName("newemployee");    
    return mv;
}
}
