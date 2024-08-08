package com.Apollonia.Employeemanagement.controllers;

import com.Apollonia.Employeemanagement.dataholders.EmployeesDh;
import com.Apollonia.Employeemanagement.dtos.EmployeesDto;
import com.Apollonia.Employeemanagement.services.employees.EmployeesServices;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeesController {

    @NonNull
    private EmployeesServices employeesServices;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesDto> create(@Validated @RequestBody final EmployeesDh employeesDh) {
        return ResponseEntity.ok(this.employeesServices.save(employeesDh));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesDto> findById(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.employeesServices.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeesDto>> findAll() {
        return ResponseEntity.ok(this.employeesServices.findAll());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesDto> updateById(@Validated @PathVariable final Long id, @Validated @RequestBody EmployeesDh employeesDh) {
        return ResponseEntity.ok(this.employeesServices.updateById(id, employeesDh));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteById(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.employeesServices.deleteById(id));
    }
}
