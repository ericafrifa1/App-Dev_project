package com.example.appdevfram_ea.dto;

import com.example.appdevfram_ea.entities.Household;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HouseholdDTO(
        @NotBlank(message = "Eircode cannot be blank") String eircode,
        @NotNull(message = "Number of occupants is required") Integer numberOfOccupants,
        @NotNull(message = "Maximum number of occupants is required") Integer maxNumberOfOccupants,
        @NotNull(message = "Owner-occupied status is required") Boolean ownerOccupied
) {
    public Household toEntity() {
        return new Household(
                this.eircode,
                this.numberOfOccupants,
                this.maxNumberOfOccupants,
                this.ownerOccupied,
                null
        );
    }
}
