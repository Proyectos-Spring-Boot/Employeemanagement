package com.Apollonia.Employeemanagement.services.departaments;

import com.Apollonia.Employeemanagement.dataholders.DepartamentsDh;
import com.Apollonia.Employeemanagement.dtos.DepartamentsDto;
import java.util.List;

public interface DepartamentsService {

    DepartamentsDto save(DepartamentsDh departamentsDh);

    DepartamentsDto findById(Long id);

    List<DepartamentsDto> findAll();

    DepartamentsDto updateById(Long id, DepartamentsDh departamentsDh);

    Boolean deleteById(Long id);

}
