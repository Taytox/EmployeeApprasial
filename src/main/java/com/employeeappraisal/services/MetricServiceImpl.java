/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.services;


import com.employeeappraisal.models.Employee;
import com.employeeappraisal.models.Metric;
import com.employeeappraisal.repositories.MetricRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Euan
 */
@Service
public class MetricServiceImpl implements MetricService{

   @Autowired
    private MetricRepository metricRepository;
    @Override
    public List<Metric> getAllMetrics() {
        
        return metricRepository.findAll();
     }

    @Override
    public void saveMetric(Metric metric) {
        this.metricRepository.save(metric);
    }

    @Override
    public Metric getMetricById(long id) {
        Optional<Metric> optional=metricRepository.findById(id);
        Metric metric = null;
        if(optional.isPresent()){
            metric = optional.get();
        }else{
                throw new RuntimeException(" Metric not found for id:: " + id);
        }
        return metric;
    }

        
    @Override
    public void deleteMetricById(long id) {
        this.metricRepository.deleteById(id);
    }
    
}
