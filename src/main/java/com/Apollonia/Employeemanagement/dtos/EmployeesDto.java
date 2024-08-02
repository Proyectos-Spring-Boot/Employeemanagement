package com.Apollonia.Employeemanagement.dtos;

import com.Apollonia.Employeemanagement.entities.Departaments;
import lombok.Data;

@Data
public class EmployeesDto {

    private Long nemployee;

    private String fullname;

    private  String phone;

    private String email;

    private String dadmission;

    private String salary;

    private Boolean position;

    private Departaments departament;

}
