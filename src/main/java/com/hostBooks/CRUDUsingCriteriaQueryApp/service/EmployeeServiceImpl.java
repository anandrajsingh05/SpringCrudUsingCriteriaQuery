package com.hostBooks.CRUDUsingCriteriaQueryApp.service;

import com.hostBooks.CRUDUsingCriteriaQueryApp.entity.EmployeeBO;
import com.hostBooks.CRUDUsingCriteriaQueryApp.dto.EmployeeTO;
import com.hostBooks.CRUDUsingCriteriaQueryApp.dao.EmployeeDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeTO addEmployee(EmployeeTO employeeTO) {
        EmployeeBO emp=this.convertTOEntity(employeeTO);
       EmployeeBO savedEmployeeBO = employeeDao.addEmployee(emp);
       return this.convertTODTO(savedEmployeeBO);
    }

    @Override
    public EmployeeTO updateEmployee(EmployeeTO employeeTO) {
       EmployeeBO employeeBO =this.convertTOEntity(employeeTO);
//       employee.setEmpId(employeeDTO.getId());
       EmployeeBO savedEmployeeBO = employeeDao.updateEmployee(employeeBO);

       return this.convertTODTO(savedEmployeeBO);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        List<Integer> list= new ArrayList<>();
        list.add(empId);
        employeeDao.delete(list);
    }

    @Override
    public EmployeeTO getEmployeeById(Integer empId) {
        EmployeeBO existingEmployeeBO = employeeDao.getById(empId);
       return this.convertTODTO(existingEmployeeBO);
    }

    @Override
    public List<EmployeeTO> getAllEmployees() {
       List<EmployeeBO> list= employeeDao.getEmployeeList();
       List<EmployeeTO> employeeTOList= new ArrayList<>();
       for(EmployeeBO emp : list){
           employeeTOList.add(this.convertTODTO(emp));
       }
       return employeeTOList;
    }


    public EmployeeBO convertTOEntity(EmployeeTO employeeTO){
        EmployeeBO emp= this.modelMapper.map(employeeTO, EmployeeBO.class);
        return emp;
    }

    public EmployeeTO convertTODTO(EmployeeBO employeeBO){
        EmployeeTO employeeTO = this.modelMapper.map(employeeBO, EmployeeTO.class);
        return employeeTO;
    }


}
