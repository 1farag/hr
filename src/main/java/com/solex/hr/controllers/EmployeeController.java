package com.solex.hr.controllers;

import com.solex.hr.models.Employee;
import com.solex.hr.repositories.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        try {
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        catch (Exception e){    
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployees(){
        try {
            List<Employee> employees = employeeRepository.findAll();
            return new ResponseEntity<>(employees,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
