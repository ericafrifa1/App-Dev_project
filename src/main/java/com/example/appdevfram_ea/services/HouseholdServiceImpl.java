package com.example.appdevfram_ea.services;

import com.example.appdevfram_ea.entities.Household;
import com.example.appdevfram_ea.repositories.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;

    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) {
        if (!householdRepository.existsById(eircode)) {
            throw new IllegalArgumentException("Household with eircode " + eircode + " does not exist.");
        }
        householdRepository.deleteById(eircode);
    }

    @Override
    public Household findHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with eircode " + eircode + " not found."));
    }

    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }
}
