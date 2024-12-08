package com.example.appdevfram_ea.controllers;

import com.example.appdevfram_ea.entities.Household;
import com.example.appdevfram_ea.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdController{

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.findHouseholdsWithNoPets();
    }

    @GetMapping("/{eircode}")
    public Household getHousehold(@PathVariable String eircode) {
        return householdService.findHouseholdByEircode(eircode);
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody Household household) {
        return ResponseEntity.ok(householdService.createHousehold(household));
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return ResponseEntity.noContent().build();
    }
}
