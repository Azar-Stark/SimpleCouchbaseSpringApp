package com.ex.couchbasespring.service;

import com.ex.couchbasespring.domain.Employee;
import com.ex.couchbasespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Employee getEmployee(String id) {
        return employeeRepository.findById(id).get();
    }
}
