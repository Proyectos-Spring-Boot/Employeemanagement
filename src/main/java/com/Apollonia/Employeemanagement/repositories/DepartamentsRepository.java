package com.Apollonia.Employeemanagement.repositories;

import com.Apollonia.Employeemanagement.entities.Departaments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentsRepository extends CrudRepository<Departaments, Long> {

}
