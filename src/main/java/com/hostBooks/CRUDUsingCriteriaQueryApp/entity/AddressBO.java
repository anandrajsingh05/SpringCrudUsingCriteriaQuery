package com.hostBooks.CRUDUsingCriteriaQueryApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AddressBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String street;
    private String city;
    private String pinCode;
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private EmployeeBO employeeBO;


}
