package com.Apollonia.Employeemanagement.controllers;

import com.Apollonia.Employeemanagement.dataholders.DepartamentsDh;
import com.Apollonia.Employeemanagement.dtos.DepartamentsDto;
import com.Apollonia.Employeemanagement.services.departaments.DepartamentsService;
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
@RequestMapping("departaments")
@RequiredArgsConstructor
public class DepartamentsController {

    @NonNull
    private DepartamentsService departamentsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartamentsDto> create(@Validated @RequestBody final DepartamentsDh departamentsDh) {
        return ResponseEntity.ok(this.departamentsService.save(departamentsDh));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartamentsDto> findById(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.departamentsService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartamentsDto>> findAll() {
        return ResponseEntity.ok(this.departamentsService.findAll());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartamentsDto> updateById(@Validated @PathVariable final Long id, @Validated @RequestBody final DepartamentsDh departamentsDh) {
        return ResponseEntity.ok(this.departamentsService.updateById(id, departamentsDh));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteById(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.departamentsService.deleteById(id));
    }
}
