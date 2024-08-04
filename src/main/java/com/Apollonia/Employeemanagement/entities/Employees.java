package com.Apollonia.Employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor

@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nemployee")
    private Long nemployee;

    @Column(name = "fullname", length = 40, nullable = false)
    private String fullname;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "dadmission", length = 11)
    private String dadmission;

    @Column(name = "position", length = 1)
    private Boolean position;

    @Column(name = "password", length = 20)
    private String password;

    @ManyToOne
    @JoinColumn(name = "cdepartament", referencedColumnName = "Cdepartament")
    @JsonIgnore
    private Departaments departament;
}
