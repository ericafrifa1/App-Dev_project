package com.example.appdevfram_ea;

import com.example.appdevfram_ea.controllers.PetController;
import com.example.appdevfram_ea.dto.PetDTO;
import com.example.appdevfram_ea.services.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(PetController.class)
class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PetService petService;

    @Test
    void getAllPets() throws Exception {
        mockMvc.perform(get("/api/pets"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createPet() throws Exception {
        String petJson = """
            {
                "name": "Buddy",
                "animalType": "Dog",
                "breed": "Golden Retriever",
                "age": 3
            }
            """;

        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(petJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
