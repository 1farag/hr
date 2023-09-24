package com.solex.hr.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "build", length = 50, nullable = false)
    private String build;
    @Column(name = "street", length = 50, nullable = false)
    private String street;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @OneToOne
    private Employee employee;

}
