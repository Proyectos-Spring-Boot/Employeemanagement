package com.Apollonia.Employeemanagement.services.departaments;

import com.Apollonia.Employeemanagement.dataholders.DepartamentsDh;
import com.Apollonia.Employeemanagement.dtos.DepartamentsDto;
import com.Apollonia.Employeemanagement.entities.Departaments;
import com.Apollonia.Employeemanagement.mapper.DepartamentsMapper;
import com.Apollonia.Employeemanagement.repositories.DepartamentsRepository;
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
public class DepartamentsServiceImpl implements DepartamentsService {

    @NonNull
    private final DepartamentsRepository departamentsRepository;

    @NonNull
    private final DepartamentsMapper departamentsMapper;

    @Override
    public DepartamentsDto save(final DepartamentsDh departamentsDh) {
        final Departaments departament = this.departamentsMapper.asEntity(departamentsDh);
        final Departaments departamentsSaved = this.departamentsRepository.save(departament);
        final DepartamentsDto departamentsDto = this.departamentsMapper.asDto(departamentsSaved);
        return departamentsDto;
    }

    @Override
    public DepartamentsDto findById(final Long id) {
        final Optional<Departaments> departament = this.departamentsRepository.findById(id);
        if (departament.isPresent()) {
            final DepartamentsDto departamentsDto = this.departamentsMapper.asDto(departament.get());
            return departamentsDto;
        } else {
            throw new BdNotFoundException("GET -  - There are no departaments in the database");
        }
    }

    @Override
    public List<DepartamentsDto> findAll() {
        final List<Departaments>  departaments = (List<Departaments>) this.departamentsRepository.findAll();
        if (CollectionUtils.isEmpty(departaments)) {
            log.warn("FINDALL - There are no departaments in the database");
            return Collections.emptyList();
        } else {
            final List<DepartamentsDto> departamentsDtoList = this.departamentsMapper.asDtoList(departaments);
            return departamentsDtoList;
        }
    }

    @Override
    public DepartamentsDto updateById(final Long id, final DepartamentsDh departamentsDh) {
        final Departaments departaments = this.departamentsMapper.asEntity(departamentsDh);
        final boolean existsDepartament = this.departamentsRepository.existsById(id);

        if (departamentsDh.getCdepartament() != id) {
            throw new BdNotSaveException("PUT - Parameters are incorrect for field Cdepartament: " + departamentsDh.getCdepartament() + " is different at id: " + id);
        }

        if (existsDepartament) {
            final Departaments departamentsSaved = this.departamentsRepository.save(departaments);
            final DepartamentsDto departamentsDto = this.departamentsMapper.asDto(departamentsSaved);
            return departamentsDto;
        }
        throw new BdNotFoundException("PUT - There is no departament in the database with the id: " + id);
    }

    @Override
    public Boolean deleteById(final Long id) {
        final boolean existsDepartament = this.departamentsRepository.existsById(id);
        if (existsDepartament) {
            this.departamentsRepository.deleteById(id);
            return true;
        }
        throw new BdNotFoundException("DELETE - There is no departament in the database with the id: " + id);
    }

}
