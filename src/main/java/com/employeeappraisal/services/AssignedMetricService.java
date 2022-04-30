/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.services;

import com.employeeappraisal.models.AssignedMetric;
import com.employeeappraisal.models.AssignedMetricKey;
import com.employeeappraisal.models.Metric;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euan
 */
public interface AssignedMetricService {
       List<AssignedMetric> getAllAssignedMetrics();
    
    //Save employ by passing the Employee object into the method
    void saveAssignedMetric(AssignedMetric metric);
    
    //get Employee by ID
    AssignedMetric getAssignedMetricById(AssignedMetricKey id);
    
    void deleteAssignedMetricById(AssignedMetricKey id); 
    
    List<AssignedMetric> getByEmployeeId(long employeeId);
}
