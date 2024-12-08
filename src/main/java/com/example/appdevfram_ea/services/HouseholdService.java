package com.example.appdevfram_ea.services;

import com.example.appdevfram_ea.entities.Household;

import java.util.List;

public interface HouseholdService {
    List<Household> getAllHouseholds();

    Household createHousehold(Household household);

    void deleteHouseholdByEircode(String eircode);

    Household findHouseholdByEircode(String eircode);

    List<Household> findHouseholdsWithNoPets();
}
