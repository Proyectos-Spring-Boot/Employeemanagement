package com.Apollonia.Employeemanagement.services.employees;

import com.Apollonia.Employeemanagement.dataholders.EmployeesDh;
import com.Apollonia.Employeemanagement.dtos.EmployeesDto;
import com.Apollonia.Employeemanagement.entities.Employees;
import com.Apollonia.Employeemanagement.mapper.EmployeesMapper;
import com.Apollonia.Employeemanagement.repositories.EmployeesRepository;
import com.Apollonia.Employeemanagement.exceptions.BdNotFoundException;
import com.Apollonia.Employeemanagement.exceptions.BdNotSaveException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesServices{

    @NonNull
    private final EmployeesRepository employeesRepository;

    @NonNull
    private final EmployeesMapper employeesMapper;

    @Override
    public EmployeesDto save(final EmployeesDh employeesDh) {
        final Employees employees = this.employeesMapper.asEntity(employeesDh);
        final Employees employeesSaved = this.employeesRepository.save(employees);
        final EmployeesDto employeesDto = this.employeesMapper.asDto(employeesSaved);
        return employeesDto;
    }

    @Override
    public EmployeesDto findById(final Long id) {
        final Optional<Employees> employees = this.employeesRepository.findById(id);
        if (employees.isPresent()) {
            final EmployeesDto employeesDto = this.employeesMapper.asDto(employees.get());
            return employeesDto;
        } else {
            throw new BdNotFoundException("GET - There is no employee in the database with the id: " + id);
        }
    }

    @Override
    public List<EmployeesDto> findAll() {
        final List<Employees> employees = (List<Employees>) this.employeesRepository.findAll();
        if (CollectionUtils.isEmpty(employees)) {
            log.warn("There are no employees in the database");
            return Collections.emptyList();
        } else {
            final List<EmployeesDto> employeesDtoList = this.employeesMapper.asDtoList(employees);
            return employeesDtoList;
        }
    }

    @Override
    public EmployeesDto updateById(final Long id, final EmployeesDh employeesDh) {
        if (employeesDh.getNemployee() != id) {
            throw new BdNotSaveException("PUT - Parameters are incorrect for field Nemployee: " + employeesDh.getNemployee() + " is different at id: " + id);
        }

        final Employees employees = this.employeesMapper.asEntity(employeesDh);
        final boolean existEmployee = this.employeesRepository.existsById(id);

        if (existEmployee) {
            final Employees employeesSaved = this.employeesRepository.save(employees);
            final EmployeesDto employeesDto = this.employeesMapper.asDto(employeesSaved);
            return employeesDto;
        }
        throw new BdNotFoundException("PUT - There is no employee in the database with the id: " + id);
    }

    @Override
    public Boolean deleteById(final Long id) {
        final boolean existsEmployee = this.employeesRepository.existsById(id);
        if (existsEmployee) {
            this.employeesRepository.deleteById(id);
            return true;
        }
        throw new BdNotFoundException("DELETE - There is no employee in the database with the id: " + id);
    }
}
