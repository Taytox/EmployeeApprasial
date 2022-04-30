/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.services;

import com.employeeappraisal.models.Employee;
import java.util.List;

/**
 *
 * @author Euan
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();
    
    //Save employ by passing the Employee object into the method
    void saveEmployee(Employee employee);
    
    //get Employee by ID
    Employee getEmployeeById(long id);
    
    void deleteEmployeeById(long id);
}
