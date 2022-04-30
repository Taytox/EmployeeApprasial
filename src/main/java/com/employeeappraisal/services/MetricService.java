/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.services;

import com.employeeappraisal.models.Metric;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euan
 */
@Service
public interface MetricService {
       List<Metric>  getAllMetrics();
    
    //Save employ by passing the Employee object into the method
    void saveMetric(Metric metric);
    
    //get Employee by ID
    Metric getMetricById(long id);
    
    void deleteMetricById(long id); 
}
