package com.Apollonia.Employeemanagement.dtos;

import com.Apollonia.Employeemanagement.entities.Employees;
import lombok.Data;

import java.util.List;

@Data
public class DepartamentsDto {

    private Long cdepartament;

    private String departament;

    private String description;

    private List<Employees> employeesList;

}
