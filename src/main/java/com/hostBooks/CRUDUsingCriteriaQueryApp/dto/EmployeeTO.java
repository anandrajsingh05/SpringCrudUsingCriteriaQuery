package com.hostBooks.CRUDUsingCriteriaQueryApp.dto;

import com.hostBooks.CRUDUsingCriteriaQueryApp.entity.AddressBO;
import lombok.*;

import javax.persistence.Column;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class EmployeeTO {

    private Long empId;
    private String name;
    private String mobile;
    private Integer salary;
    private boolean deleteFlag;
    private Map<String, AddressBO> address = new HashMap<>();

}
