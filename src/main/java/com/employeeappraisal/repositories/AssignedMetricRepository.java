/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employeeappraisal.repositories;

import com.employeeappraisal.models.AssignedMetric;
import com.employeeappraisal.models.AssignedMetricKey;
import com.employeeappraisal.models.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Euan
 */
@Repository
public interface AssignedMetricRepository extends JpaRepository<AssignedMetric, AssignedMetricKey>{
   List<AssignedMetric> findByEmployee_id(long EmployeeID);
}