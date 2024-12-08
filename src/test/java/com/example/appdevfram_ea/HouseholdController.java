package com.example.appdevfram_ea;

import com.example.appdevfram_ea.controllers.HouseholdController;
import com.example.appdevfram_ea.services.HouseholdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(HouseholdController.class)
class HouseholdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HouseholdService householdService;

    @Test
    void getAllHouseholds() throws Exception {
        mockMvc.perform(get("/api/households"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createHousehold() throws Exception {
        String householdJson = """
            {
                "eircode": "D02XY45",
                "numberOfOccupants": 3,
                "maxNumberOfOccupants": 5,
                "ownerOccupied": true
            }
            """;

        mockMvc.perform(post("/api/households")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(householdJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
