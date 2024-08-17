package com.Apollonia.Employeemanagement.dtos;

import com.Apollonia.Employeemanagement.entities.Departaments;
import lombok.Data;

import java.util.List;

@Data
public class EmployeesDto {

    private Long nemployee;

    private String fullname;

    private String phone;

    private String email;

    private String dadmission;

    private Double salary;

    private Boolean position;

    private String password;

    private Departaments departaments;

}
