package com.example.appdevfram_ea.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDTO(
        @NotBlank(message = "Name cannot be blank") String name,
        @NotBlank(message = "Animal type cannot be blank") String animalType,
        @NotBlank(message = "Breed cannot be blank") String breed,
        @NotNull(message = "Age cannot be null") Integer age,
        @NotBlank(message = "Household eircode is required") String householdEircode
) {}
