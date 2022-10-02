package com.hostBooks.CRUDUsingCriteriaQueryApp.dao;

import com.hostBooks.CRUDUsingCriteriaQueryApp.entity.EmployeeBO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDao {

    EmployeeBO addEmployee(EmployeeBO employeeBO);

   EmployeeBO updateEmployee(EmployeeBO employeeBO);

    List<EmployeeBO> getEmployeeList();

    EmployeeBO getById(Integer id);

    void delete(List<Integer> id);

}
