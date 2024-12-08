package com.example.appdevfram_ea.services;

import com.example.appdevfram_ea.dto.PetDTO;
import com.example.appdevfram_ea.entities.Household;
import com.example.appdevfram_ea.entities.Pet;
import com.example.appdevfram_ea.repositories.HouseholdRepository;
import com.example.appdevfram_ea.repositories.PetRepository;
import org.dataloader.stats.Statistics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final HouseholdRepository householdRepository;

    public PetServiceImpl(PetRepository petRepository, HouseholdRepository householdRepository) {
        this.petRepository = petRepository;
        this.householdRepository = householdRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with ID " + id + " not found."));
    }

    @Override
    public Pet createPet(PetDTO petDTO) {
        Household household = householdRepository.findById(petDTO.householdEircode())
                .orElseThrow(() -> new IllegalArgumentException("Household with eircode " + petDTO.householdEircode() + " not found."));

        Pet pet = new Pet();
        pet.setName(petDTO.name());
        pet.setAnimalType(petDTO.animalType());
        pet.setBreed(petDTO.breed());
        pet.setAge(petDTO.age());
        pet.setHousehold(household);

        return petRepository.save(pet);
    }

    @Override
    public Pet updatePetName(Long id, String newName) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with ID " + id + " not found."));
        pet.setName(newName);
        return petRepository.save(pet);
    }

    @Override
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new IllegalArgumentException("Pet with ID " + id + " does not exist.");
        }
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> getPetsByAnimalType(String animalType) {
        return List.of();
    }

    @Override
    public Statistics getPetStatistics() {
        return null;
    }


}
