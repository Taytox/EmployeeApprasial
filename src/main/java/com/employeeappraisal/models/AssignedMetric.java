/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Euan
 */
@Entity
@Table(name = "assigned_metrics")
public class AssignedMetric implements Serializable {
    
    @EmbeddedId
    AssignedMetricKey id;
   
    @ManyToOne
    @MapsId("employee")
    @JoinColumn(name="employee_id")
    Employee employee;
   
    @ManyToOne
    @MapsId("metric")
    @JoinColumn(name="metric_id")
    Metric metric;
   
    @Column(name = "current_value")
    String currentValue;   
    
public AssignedMetric(){  
}
    
public AssignedMetric(AssignedMetricKey id, Employee employee, Metric metric, String currentValue) {
    this.id = id;
    this.employee = employee;
    this.metric = metric;
    this.currentValue = currentValue;
}

public AssignedMetricKey getId(){
    return id;
}
public Employee getEmployee() {
    return employee;
}

public void setEmployee(Employee employee) {
    this.employee = employee;
}
    
public long getEmployeeID(){
    return employee.getId();
}
    
public Metric getMetric() {
    return metric;
}

public void setMetric(Metric metric) {
    this.metric = metric;
}

public long getMetricID(){
    return metric.getId();
}

public String getMetricType(){
    return metric.getMetricType();
}

public String getCurrentValue() {
    return currentValue;
}

public String getTargetValue(){
    return metric.getTargetValue();
}

public void setCurrentValue(String value) {
    this.currentValue = value;
}
   
public String displayMetricProgress(){
    return metric.toString() + ", current value is : " + currentValue;     
}

@Override
public int hashCode() {
    int hash = 7;
    hash = 23 * hash + Objects.hashCode(this.employee);
    hash = 23 * hash + Objects.hashCode(this.metric);
    hash = 23 * hash + Objects.hashCode(this.currentValue);
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
    final AssignedMetric other = (AssignedMetric) obj;
        if (!Objects.equals(this.currentValue, other.currentValue)) {
            return false;
        }
    return Objects.equals(this.employee, other.employee);
} 
}

