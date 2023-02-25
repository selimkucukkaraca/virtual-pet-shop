package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.TestUtil;
import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetTypeRequest;
import com.pets.virtualpetshop.model.PetType;
import com.pets.virtualpetshop.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetTypeServiceTest extends TestUtil {

    private PetTypeRepository petTypeRepository;
    private PetTypeService petTypeService;

    @BeforeEach
    public void setUp(){
        petTypeRepository = mock(PetTypeRepository.class);
        petTypeService = new PetTypeService(petTypeRepository);
    }
 
    @Test
    public void testSavePetType_itShouldReturnPetTypeDto(){
        //given
        CreatePetTypeRequest request = new CreatePetTypeRequest("test","test");
        PetType petType = new PetType("test","test");
        PetTypeDto petTypeDto = new PetTypeDto("test","test");

        //when
        when(petTypeRepository.save(petType)).thenReturn(petType);

        PetTypeDto response = petTypeService.save(request);
        //then
        assertEquals(response,petTypeDto);
    }

    @Test
    public void getAll_itShouldReturnPetTypeDtoList(){
        //given
        List<PetTypeDto> petTypeDtoList = getPetTypeDtoList();
        List<PetType> petTypeList = getPetTypeList();

        //when
        when(petTypeRepository.findAll()).thenReturn(petTypeList);

        List<PetTypeDto> response = petTypeService.getAll();

        //then
        assertEquals(response,petTypeDtoList);
        verify(petTypeRepository).findAll();
    }

    @Test
    public void getPetTypeByType_itShouldReturnPetType(){
        //given
        PetType petType = getPetTypeList().get(0);
        String typeOfAnimal = "test";
        String breedOfAnimal = "test";

        //when
        when(petTypeRepository.findPetTypeByTypeOfAnimalAndBreedOfAnimal(typeOfAnimal,breedOfAnimal)).thenReturn(petType);

        PetType response = petTypeService.getPetTypeByType(typeOfAnimal,breedOfAnimal);

        //then
        assertEquals(response,petType);
        verify(petTypeRepository).findPetTypeByTypeOfAnimalAndBreedOfAnimal(typeOfAnimal,breedOfAnimal);
    }

    @Test
    public void delete(){
        //given
        PetType petType = getPetTypeList().get(0);
        String typeOfAnimal = "test";
        String breedOfAnimal = "test";

        //when
        petTypeRepository.delete(petType);

        petTypeService.delete(typeOfAnimal, breedOfAnimal);

        //then
        verify(petTypeRepository).delete(petType);

    }


}