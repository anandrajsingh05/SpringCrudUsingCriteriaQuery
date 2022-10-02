package com.hostBooks.CRUDUsingCriteriaQueryApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    private String name;

    private String mobile;

    private Integer salary;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_address",
            joinColumns = {
                    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
            })
    private Map<String, AddressBO> address = new HashMap<>();


}
