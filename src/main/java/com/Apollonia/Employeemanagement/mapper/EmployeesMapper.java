package com.Apollonia.Employeemanagement.mapper;

import com.Apollonia.Employeemanagement.dataholders.EmployeesDh;
import com.Apollonia.Employeemanagement.dtos.EmployeesDto;
import com.Apollonia.Employeemanagement.entities.Employees;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeesMapper {

    Employees asEntity(EmployeesDh employeesDh);

    EmployeesDto asDto(Employees employees);

    List<Employees> asEntityList(List<EmployeesDh> employeesDhList);

    List<EmployeesDto> asDtoList(List<Employees> employees);

}
