
package com.employeeappraisal.services;

import com.employeeappraisal.models.Employee;
import com.employeeappraisal.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
//    Create get all employee method - return a list of employees to the controller
    public List<Employee> getAllEmployees() {
        
        return employeeRepository.findAll();
     }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional=employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{
                throw new RuntimeException(" Employee not found for id:: " + id);
        }
        return employee;
    }

        
    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
    
}
