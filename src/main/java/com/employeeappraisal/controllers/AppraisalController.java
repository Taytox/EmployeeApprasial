/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.controllers;

import com.employeeappraisal.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Euan
 */
@Controller
public class AppraisalController {
      
@GetMapping("/index")
public String viewHomePage (Model model){ 
     return "redirect:/login";
} 
 @GetMapping("/login")
 public String viewLoginPage (Model model){ 
     model.addAttribute("login", new Login());
     return "login";
} 
 @GetMapping("/")
 public String getRoot(Model model){  
    return "redirect:/login";
 }
@GetMapping("/dashboard")
 public String getDashboard(Model model){  
return "dashboard";
 }

 @PostMapping("/dashboard")
 public String viewDashboard(@ModelAttribute("login")Login login,Model model){
     if (login.getPassword().equals("DemoPassword")){
         return "dashboard";
     }else{
         model.addAttribute("message","Incorrect Password");
        return "redirect:/login"; 
     }
  
 }
 
}
