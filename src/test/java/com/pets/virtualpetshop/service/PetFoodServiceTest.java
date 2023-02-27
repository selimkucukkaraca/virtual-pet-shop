package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.TestUtil;
import com.pets.virtualpetshop.dto.PetFoodDto;
import com.pets.virtualpetshop.dto.converter.PetFoodConverter;
import com.pets.virtualpetshop.dto.request.CreatePetFoodRequest;
import com.pets.virtualpetshop.model.PetFood;
import com.pets.virtualpetshop.repository.PetFoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetFoodServiceTest extends TestUtil {

    private PetFoodRepository petFoodRepository;
    private PetFoodService petFoodService;
    private PetFoodConverter petFoodConverter;

    @BeforeEach
    public void setUp(){
        petFoodRepository = mock(PetFoodRepository.class);
        petFoodConverter = mock(PetFoodConverter.class);
        petFoodService = new PetFoodService(petFoodRepository, petFoodConverter);
    }

    @Test
    public void savePetFood_itShouldReturnPetFoodDto(){
        CreatePetFoodRequest request = getCreatePetFoodRequest();
        PetFood petFood = getPetFoodList().get(0);
        PetFoodDto petFoodDto = getPetFoodDtoList().get(0);

        when(petFoodConverter.toEntity(request)).thenReturn(petFood);
        when(petFoodRepository.findPetFoodByPublicId("test")).thenReturn(Optional.ofNullable(petFood));
        when(petFoodRepository.save(Objects.requireNonNull(petFood))).thenReturn(petFood);
        when(petFoodConverter.convertToDto(petFood)).thenReturn(petFoodDto);

        PetFoodDto response = petFoodService.save(request);

        assertEquals(response,petFoodDto);

        verify(petFoodRepository).save(petFood);
        verify(petFoodConverter).convertToDto(petFood);
        verify(petFoodConverter).toEntity(request);
    }

    @Test
    public void getPetFoodByPublicId_itShouldReturnPetFood(){
        PetFood petFood = getPetFoodList().get(0);
        String publicId = "test";

        when(petFoodRepository.findPetFoodByPublicId(publicId)).thenReturn(Optional.ofNullable(petFood));

        PetFood response = petFoodService.getPetFoodByPublicId(publicId);

        assertEquals(response,petFood);
        verify(petFoodRepository).findPetFoodByPublicId(publicId);
    }

    @Test
    public void getByPublicId_itShouldReturnPetFoodDto(){
        PetFood petFood = getPetFoodList().get(0);
        PetFoodDto petFoodDto = getPetFoodDtoList().get(0);
        String publicId = "test";

        when(petFoodRepository.findPetFoodByPublicId(publicId)).thenReturn(Optional.ofNullable(petFood));

        assert petFood != null;
        when(petFoodConverter.convertToDto(petFood)).thenReturn(petFoodDto);

        PetFoodDto response = petFoodService.getByPublicId(publicId);

        assertEquals(response,petFoodDto);
        verify(petFoodRepository).findPetFoodByPublicId(publicId);
        verify(petFoodConverter).convertToDto(petFood);
    }

    /*
    @Test
    public void delete(){
        PetFood petFood = getPetFoodList().get(0);
        String publicId = "test";

        petFoodRepository.delete(petFood);

        petFoodService.delete(publicId);

        verify(petFoodRepository).delete(petFood);
    }
    */
}