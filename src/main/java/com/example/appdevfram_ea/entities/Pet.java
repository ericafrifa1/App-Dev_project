package com.example.appdevfram_ea.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "animal_type")
    private String animalType;

    @Column(nullable = false, name = "breed")
    private String breed;

    @Column(nullable = false, name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "household_eircode", nullable = false)
    private Household household;
}