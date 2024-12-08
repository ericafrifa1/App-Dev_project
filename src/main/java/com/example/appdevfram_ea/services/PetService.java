package com.example.appdevfram_ea.services;

import com.example.appdevfram_ea.entities.Pet;
import com.example.appdevfram_ea.dto.PetDTO;
import org.dataloader.stats.Statistics;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();

    Pet getPetById(Long id);

    Pet createPet(PetDTO petDTO);

    Pet updatePetName(Long id, String newName);

    void deletePetById(Long id);

    List<Pet> getPetsByAnimalType(String animalType);

    Statistics getPetStatistics();
}
