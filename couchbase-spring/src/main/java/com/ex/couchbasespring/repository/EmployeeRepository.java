package com.ex.couchbasespring.repository;

import com.ex.couchbasespring.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    List<Employee> findByFirstName(String firstName);
}
