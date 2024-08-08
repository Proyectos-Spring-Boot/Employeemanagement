package com.Apollonia.Employeemanagement.dataholders;

import com.Apollonia.Employeemanagement.entities.Employees;
import lombok.Data;
import java.util.List;

@Data
public class DepartamentsDh {

    private Long cdepartament;

    private String departament;

    private String description;

    private List<Employees> employeesList;

}
