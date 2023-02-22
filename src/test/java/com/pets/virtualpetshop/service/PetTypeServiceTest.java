package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetTypeRequest;
import com.pets.virtualpetshop.model.PetType;
import com.pets.virtualpetshop.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetTypeServiceTest {

    private PetTypeRepository petTypeRepository;
    private PetTypeService petTypeService;

    @BeforeEach
    public void setUp(){
        petTypeRepository = mock(PetTypeRepository.class);
        petTypeService = new PetTypeService(petTypeRepository);
    }

    @Test
    public void testSavePetType_itShouldReturnPetTypeDto(){
        CreatePetTypeRequest request = new CreatePetTypeRequest("test","test");
        PetType petType = new PetType("test","test");
        PetTypeDto petTypeDto = new PetTypeDto("test","test");

        when(petTypeRepository.save(petType)).thenReturn(petType);

        PetTypeDto response = petTypeService.save(request);

        assertEquals(response,petTypeDto);
    }
}