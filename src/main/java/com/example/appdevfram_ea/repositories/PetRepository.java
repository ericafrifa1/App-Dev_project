package com.example.appdevfram_ea.repositories;

import com.example.appdevfram_ea.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAnimalType(String animalType);
}
