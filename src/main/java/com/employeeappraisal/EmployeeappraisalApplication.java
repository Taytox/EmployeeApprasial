package com.employeeappraisal;

import com.employeeappraisal.models.AssignedMetric;
import com.employeeappraisal.models.AssignedMetricKey;
import com.employeeappraisal.models.Employee;
import com.employeeappraisal.models.Metric;
import com.employeeappraisal.repositories.AssignedMetricRepository;
import com.employeeappraisal.repositories.EmployeeRepository;
import com.employeeappraisal.repositories.MetricRepository;
import com.employeeappraisal.services.MetricService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Comment for Demo Commit

@SpringBootApplication
public class EmployeeappraisalApplication {
      private static final Logger log = LoggerFactory.getLogger(EmployeeappraisalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappraisalApplication.class, args);
	}

        /*@Bean
        public CommandLineRunner demo(EmployeeRepository repository,AssignedMetricRepository asRepository,MetricRepository mRepo) {
        return (args) -> {
        // save a few customers
        ArrayList<Employee> testUsers = new ArrayList<Employee>();
        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Employee customer : repository.findAll()) {
        log.info(customer.toString());
        testUsers.add(customer);
        }
        log.info("");
        
        // fetch an individual customer by ID
        Optional<Employee> customer = repository.findById(5L);
        log.info("Customer found with findById(5):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");
        
        List<AssignedMetric> metric = asRepository.findByEmployee_id(1);
        log.info("metrics found with findById(1):");
        log.info("--------------------------------");
        if (metric.isEmpty()){
        log.info("No match!");
        }else{
        log.info(metric.toString());
        }
        log.info("");
        // fetch customers by last name
        ArrayList<Metric> testMetric = new ArrayList<Metric>();
        log.info("all Metrics:");
        log.info("--------------------------------------------");
        
        for (Metric newMetric : mRepo.findAll()) {
        log.info(newMetric.toString());
        testMetric.add(newMetric);
        }
        // repository.findByLastName("Bauer").forEach(bauer -> {
        // log.info(bauer.toString());
        // });
        // for (Customer bauer : repository.findByLastName("Bauer")) {
        //  log.info(bauer.toString());
        // }
        log.info("");
        };
        }
*/
      
}
