package com.solex.hr.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "grade", nullable = false)
    private String grade;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "salary", nullable = false)
    private Double salary;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "hiring_date", columnDefinition = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hiringDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
