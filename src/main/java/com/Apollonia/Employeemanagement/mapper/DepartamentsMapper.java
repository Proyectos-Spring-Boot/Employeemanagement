package com.Apollonia.Employeemanagement.mapper;

import com.Apollonia.Employeemanagement.dataholders.DepartamentsDh;
import com.Apollonia.Employeemanagement.dtos.DepartamentsDto;
import com.Apollonia.Employeemanagement.entities.Departaments;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentsMapper {

    Departaments asEntity(DepartamentsDh departamentsDh);

    DepartamentsDto asDto(Departaments departaments);

    List<Departaments> asEntityList(List<DepartamentsDh> departamentsDhList);

    List<DepartamentsDto> asDtoList(List<Departaments> departaments);

}
