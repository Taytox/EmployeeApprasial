/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

/**
 *
 * @author Euan
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_ID")
    private long id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    
    @Nullable
    @ManyToOne
    @JoinColumn(name="line_manager")
    private Employee lineManger;
    
    @OneToMany(mappedBy = "lineManger")
    private List<Employee> subordinates;
    
    @Nullable
    @OneToMany(mappedBy = "employee")
    private List<AssignedMetric> metrics;
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public Employee getLineManager() {
        return lineManger;
    }

    public void setLineManager(Employee lineManager) {
        this.lineManger = lineManager;
    }

    public List<AssignedMetric> getMetrics() {
        return metrics;
    }
    
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void setMetrics(List<AssignedMetric> metrics) {
        this.metrics = metrics;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", dob=").append(dob);
        if(lineManger == null){
         sb.append(", lineManger=").append("No line manager") ;  
        }else{
        sb.append(", lineManger=").append(lineManger.getFullName());
        }
        sb.append('}');
        return sb.toString();
    }

}