package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.TestUtil;
import com.pets.virtualpetshop.dto.PetFoodTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetFoodTypeRequest;
import com.pets.virtualpetshop.model.PetFoodType;
import com.pets.virtualpetshop.repository.PetFoodTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetFoodTypeServiceTest extends TestUtil {

    private PetFoodTypeRepository petFoodTypeRepository;
    private PetFoodTypeService petFoodTypeService;

    @BeforeEach
    public void setUp(){
        petFoodTypeRepository = mock(PetFoodTypeRepository.class);
        petFoodTypeService = new PetFoodTypeService(petFoodTypeRepository);
    }

    @Test
    public void savePetFoodType_itShouldReturnPetFoodTypeDto(){

        CreatePetFoodTypeRequest request = getCreatePetFoodTypeRequest();
        PetFoodType petFoodType = getPetFoodTypeList().get(0);
        PetFoodTypeDto petFoodTypeDto = getPetFoodTypeDtoList().get(0);

        when(petFoodTypeRepository.save(petFoodType)).thenReturn(petFoodType);

        PetFoodTypeDto response = petFoodTypeService.save(request);

        assertEquals(response,petFoodTypeDto);
    }

    @Test
    public void getAll_itShouldReturnPetFoodTypeDtoList(){

        List<PetFoodTypeDto> petFoodTypeDtoList = getPetFoodTypeDtoList();
        List<PetFoodType> petFoodTypeList = getPetFoodTypeList();

        when(petFoodTypeRepository.findAll()).thenReturn(petFoodTypeList);

        List<PetFoodTypeDto> response = petFoodTypeService.getAll();

        assertEquals(response,petFoodTypeDtoList);
        verify(petFoodTypeRepository).findAll();
    }

    @Test
    public void getPetFoodTypeByType_itShouldReturnPetFoodType(){

        PetFoodType petFoodType = getPetFoodTypeList().get(0);
        String typeOfFood = "test";

        when(petFoodTypeRepository.findPetFoodTypeByTypeOfFood(typeOfFood)).thenReturn(petFoodType);

        PetFoodType response = petFoodTypeService.getPetFoodTypeByType(typeOfFood);

        assertEquals(response,petFoodType);
        verify(petFoodTypeRepository).findPetFoodTypeByTypeOfFood(typeOfFood);

    }

    @Test
    public void delete(){

        PetFoodType petFoodType = getPetFoodTypeList().get(0);
        String typeOfFood = "test";

        petFoodTypeRepository.delete(petFoodType);

        petFoodTypeService.delete(typeOfFood);

        verify(petFoodTypeRepository).delete(petFoodType);

    }
}