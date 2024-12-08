package com.example.appdevfram_ea.controllers;

import com.example.appdevfram_ea.dto.PetDTO;
import com.example.appdevfram_ea.entities.Pet;
import com.example.appdevfram_ea.services.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petService.createPet(petDTO));
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<Pet> changePetName(@PathVariable Long id, @RequestBody String newName) {
        return ResponseEntity.ok(petService.updatePetName(id, newName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }
}
