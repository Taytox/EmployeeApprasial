/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Euan
 */
        
@Embeddable
public class AssignedMetricKey implements Serializable{
    @Column(name="employee_id")
    private long employee; 
    
    @Column(name="metric_id")
    private long metric;
    public AssignedMetricKey() {
 
    }
    public AssignedMetricKey(long e, long m) {
        this.employee = e;
        this.metric = m;
    }



    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public long getMetric() {
        return metric;
    }

    public void setMetric(long metric) {
        this.metric = metric;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssignedMetricKey other = (AssignedMetricKey) obj;
        if (this.employee != other.employee) {
            return false;
        }
        return this.metric == other.metric;
    }
    
    
}

