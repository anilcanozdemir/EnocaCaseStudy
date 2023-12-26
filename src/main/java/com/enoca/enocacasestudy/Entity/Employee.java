package com.enoca.enocacasestudy.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")

    private Company company;
    @Column

    private String name;
    @Column

    private String surname;
    @Column

    private Double salary;
    @Column
    private Integer age;
    @Column

    private String email;


}