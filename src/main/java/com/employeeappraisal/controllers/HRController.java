/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.controllers;

import com.employeeappraisal.services.EmployeeService;
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
public class HRController {

@Autowired
private EmployeeService employeeService;
    @GetMapping("/hroverview")
    public ModelAndView viewHROverview (Model model){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("hroverview");
    mv.addObject("listEmployees", employeeService.getAllEmployees());
    return mv;
} 
}
