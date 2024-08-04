package com.Apollonia.Employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departaments")
public class Departaments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cdepartament")
    private Long cdepartament;

    @Column(name = "departament", length = 25, nullable = false)
    private String departament;

    @Column(name = "description", length = 50)
    private String description;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    @JsonIgnore
    private List<Employees> employeesList;
}
