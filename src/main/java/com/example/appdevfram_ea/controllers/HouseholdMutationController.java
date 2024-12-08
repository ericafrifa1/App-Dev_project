package com.example.appdevfram_ea.controllers;

import com.example.appdevfram_ea.dto.HouseholdDTO;
import com.example.appdevfram_ea.entities.Household;
import com.example.appdevfram_ea.services.HouseholdService;
import com.example.appdevfram_ea.services.PetService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HouseholdMutationController {

    private final HouseholdService householdService;
    private final PetService petService;

    public HouseholdMutationController(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    @MutationMapping
    public Household createHousehold(HouseholdDTO input) {
        return householdService.createHousehold(input.toEntity());
    }

    @MutationMapping
    public String deleteHouseholdById(String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return "Household deleted successfully.";
    }

    @MutationMapping
    public String deletePetById(Long id) {
        petService.deletePetById(id);
        return "Pet deleted successfully.";
    }
}
