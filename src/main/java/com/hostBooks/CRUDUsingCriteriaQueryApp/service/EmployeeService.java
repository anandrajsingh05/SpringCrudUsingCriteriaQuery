package com.hostBooks.CRUDUsingCriteriaQueryApp.service;

import com.hostBooks.CRUDUsingCriteriaQueryApp.dto.EmployeeTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeTO addEmployee(EmployeeTO employeeTO);

    public EmployeeTO updateEmployee(EmployeeTO employeeTO);

    public void deleteEmployee(Integer empId);

    public EmployeeTO getEmployeeById(Integer empId);

    public List<EmployeeTO> getAllEmployees();

}
