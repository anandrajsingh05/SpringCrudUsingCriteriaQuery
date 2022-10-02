package com.hostBooks.CRUDUsingCriteriaQueryApp.controller;

import com.hostBooks.CRUDUsingCriteriaQueryApp.dto.EmployeeTO;
import com.hostBooks.CRUDUsingCriteriaQueryApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployeeController(@RequestBody EmployeeTO employeeTO){
        EmployeeTO employee= employeeService.addEmployee(employeeTO);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployeeController(@RequestBody EmployeeTO employeeTO){
        EmployeeTO employee= employeeService.updateEmployee(employeeTO);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getEmployeeController(@RequestParam Integer empId){
        EmployeeTO employee= employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployeeController(@RequestParam Integer empId){
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllEmployeeController(){
        List<EmployeeTO> allEmployees= employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }








}
