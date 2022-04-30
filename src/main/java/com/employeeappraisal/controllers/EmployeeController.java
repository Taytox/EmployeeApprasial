/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.controllers;

import com.employeeappraisal.models.AssignedMetric;
import com.employeeappraisal.models.AssignedMetricKey;
import com.employeeappraisal.models.Employee;
import com.employeeappraisal.models.Metric;
import com.employeeappraisal.services.AssignedMetricService;
import com.employeeappraisal.services.EmployeeService;
import com.employeeappraisal.services.MetricService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Euan
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MetricService metricService;
    @Autowired
    private AssignedMetricService assignedMetricService;
    
    
    
    
@GetMapping("/employee/{id}")
public ModelAndView viewEmployee (@PathVariable( value = "id")int id, Model model){ 
    Employee employee = employeeService.getEmployeeById(id);
    ModelAndView mv = new ModelAndView();
    mv.setViewName("employee");
    mv.addObject("foundEmployee", employee);
    return mv;
    
}
@GetMapping("/showFormForUpdate/{id}")
public ModelAndView showFormForUpdate(@PathVariable( value = "id") long id,@RequestParam (required = false) String action,@RequestParam (required = false) Long metric, Model model){
    Employee employee = employeeService.getEmployeeById(id);
    List<Employee> allEmployees = employeeService.getAllEmployees();
    List<Employee> suitableLineManagers = new ArrayList<>();
    List<Metric> allMetrics = metricService.getAllMetrics();
    List<AssignedMetric> assignedMetrics = employee.getMetrics();
    List<Metric> nonAssignedMetrics = new ArrayList<Metric>(); 
    List<Metric> assignedMetricsByID = new ArrayList<Metric>();
    boolean alreadyAssigned = false;
    

    for (Employee currentEmployee : allEmployees) {
        if(!currentEmployee.equals(employee) ){
            suitableLineManagers.add(currentEmployee);
        } 
    }
      
    
    if (action != null){
        if(action.equals("add")){
            for(AssignedMetric passedMetric : assignedMetrics){
                if(passedMetric.getMetricID() == metric){
                    alreadyAssigned = true;
                }
            }     
            if(alreadyAssigned == false){
                Metric metricToAssign = metricService.getMetricById(metric);
              
                //Generate a random int to simulate current value of new metric being pulled in from another system.
                Random rand = new Random();
                int randomInt = rand.nextInt(15);
        
                AssignedMetric newMetric = new AssignedMetric(new AssignedMetricKey(employee.getId(),metric),employee,metricToAssign,String.valueOf(randomInt));
                assignedMetrics.add(newMetric);
                employee.setMetrics(assignedMetrics);
                for(AssignedMetric newMetrics : employee.getMetrics() ){
                    assignedMetricService.saveAssignedMetric(newMetrics);
                }
            }
        } else if(action.equals("remove")){
            for(AssignedMetric metricToRemove : assignedMetrics){
                if(metricToRemove.getMetricID() == metric){
                    assignedMetricService.deleteAssignedMetricById(metricToRemove.getId());
                    assignedMetrics = assignedMetricService.getByEmployeeId(employee.getId());
                }
            }     
        }
      }  
            
            
            
        for(AssignedMetric assignedMetric : assignedMetrics){
            assignedMetricsByID.add(metricService.getMetricById(assignedMetric.getMetricID()));
        }
     
      
    nonAssignedMetrics = allMetrics;
    nonAssignedMetrics.removeAll(assignedMetricsByID);
      
      
    ModelAndView mv = new ModelAndView();
    mv.setViewName("updateemployee");
    //set employee as a model attribute to pre-populate th form
    mv.addObject("employee", employee);
    mv.addObject("linemanagers",suitableLineManagers);
    mv.addObject("allMetrics",allMetrics);
    mv.addObject("assignedMetrics",assignedMetrics);
    mv.addObject("nonAssignedMetrics",nonAssignedMetrics);
    mv.addObject("allEmployees", employeeService.getAllEmployees());
    return mv;
}

    
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable( value = "id")long id,Model model){
        Employee employeeToDelete = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(employeeToDelete.getId());
        return "redirect:/hroverview";
    }
    
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee,Model model){    
    employeeService.saveEmployee(employee);
    return "redirect:/dashboard";
    }    
}
