package com.example.appdevfram_ea.controllers;

import com.example.appdevfram_ea.entities.Household;
import com.example.appdevfram_ea.entities.Pet;
import com.example.appdevfram_ea.services.HouseholdService;
import com.example.appdevfram_ea.services.PetService;
import org.dataloader.stats.Statistics;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HouseholdGraphQLController {

    private final HouseholdService householdService;
    private final PetService petService;

    public HouseholdGraphQLController(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    public List<Pet> getPetsByAnimalType(String animalType) {
        return petService.getPetsByAnimalType(animalType);
    }

    @QueryMapping
    public Household getHousehold(String eircode) {
        return householdService.findHouseholdByEircode(eircode);
    }

    @QueryMapping
    public Pet getPet(Long id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    public Statistics getStatistics() {
        return petService.getPetStatistics();
    }
}
