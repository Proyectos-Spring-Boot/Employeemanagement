package com.Apollonia.Employeemanagement.dataholders;

import com.Apollonia.Employeemanagement.entities.Departaments;
import lombok.Data;
import java.util.List;

@Data
public class EmployeesDh {

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
