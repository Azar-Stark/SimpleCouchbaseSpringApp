package com.ex.couchbasespring;

import com.ex.couchbasespring.domain.Employee;
import com.ex.couchbasespring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LittleTest implements CommandLineRunner {

    @Autowired
    EmployeeService service;

    @Override
    public void run(String... args) throws Exception {
        Employee emp = new Employee();
        emp.setId("1");
        emp.setFirstName("Azar");
        emp.setLastName("Azar");
        emp.setSalary(999.55);
        service.create(emp);
    }
}
