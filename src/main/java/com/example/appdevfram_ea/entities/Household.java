package com.example.appdevfram_ea.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "household")
@AllArgsConstructor
@NoArgsConstructor
public class Household {

    @Id
    private String eircode;

    @Column(name = "number_of_occupants", nullable = false)
    private int numberOfOccupants;

    @Column(name = "max_number_of_occupants", nullable = false)
    private int maxNumberOfOccupants;

    @Column(name = "owner_occupied", nullable = false)
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets;
}