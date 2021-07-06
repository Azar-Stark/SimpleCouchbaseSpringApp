package com.ex.couchbasespring.rest;

import com.ex.couchbasespring.domain.Employee;
import com.ex.couchbasespring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity createEmployee(@Valid @RequestBody Employee employee) throws URISyntaxException {
        Employee newEmployee = employeeService.create(employee);

        return ResponseEntity.created(new URI("/api/v1/employee/" + newEmployee.getId())).build();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") String id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else return ResponseEntity.ok().body(employee);
    }
}
