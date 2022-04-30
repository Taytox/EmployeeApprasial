/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.services;

import com.employeeappraisal.models.AssignedMetric;
import com.employeeappraisal.models.AssignedMetricKey;
import com.employeeappraisal.models.Employee;
import com.employeeappraisal.repositories.AssignedMetricRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euan
 */
@Service
public class AssignedMetricServiceImpl  implements AssignedMetricService{

    @Autowired
    private AssignedMetricRepository assignedmetricRepository;
    @Override
//    Create get all employee method - return a list of employees to the controller
    public List<AssignedMetric> getAllAssignedMetrics() {
        
        return assignedmetricRepository.findAll();
     }

    @Override
    public void saveAssignedMetric(AssignedMetric metric) {
        this.assignedmetricRepository.save(metric);
    }

    @Override
    public AssignedMetric getAssignedMetricById(AssignedMetricKey id) {
        Optional<AssignedMetric> optional=assignedmetricRepository.findById(id);
        AssignedMetric metric = null;
        if(optional.isPresent()){
            metric = optional.get();
        }else{
                throw new RuntimeException(" Metric not found for id:: " + id);
        }
        return metric;
    }

        
    @Override
    public void deleteAssignedMetricById(AssignedMetricKey id) {
        this.assignedmetricRepository.deleteById(id);
    }
    
    @Override
    public List<AssignedMetric> getByEmployeeId(long employeeId){
        return assignedmetricRepository.findByEmployee_id(employeeId);
    }
    
}
