package com.Apollonia.Employeemanagement.services.employees;

import com.Apollonia.Employeemanagement.dataholders.EmployeesDh;
import com.Apollonia.Employeemanagement.dtos.EmployeesDto;
import java.util.List;

public interface EmployeesServices {

    EmployeesDto save(EmployeesDh employeesDh);

    EmployeesDto findById(Long id);

    List<EmployeesDto> findAll();

    EmployeesDto updateById(Long id, EmployeesDh employeesDh);

    Boolean deleteById(Long id);

}
