package com.pets.virtualpetshop.service;

import com.pets.virtualpetshop.TestUtil;
import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.converter.PetConverter;
import com.pets.virtualpetshop.dto.request.CreatePetRequest;
import com.pets.virtualpetshop.model.Pet;
import com.pets.virtualpetshop.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest extends TestUtil {

    private PetRepository petRepository;
    private PetService petService;
    private PetConverter petConverter;

    @BeforeEach
    public void setUp(){
       petRepository = mock(PetRepository.class);
       petConverter = mock(PetConverter.class);
       petService = new PetService(petRepository,petConverter);
    }

    @Test
    public void savePet_itShouldReturnPetDto(){
        //given
        CreatePetRequest request = getCreatePetRequest();
        Pet pet = getPetList().get(0);
        PetDto petDto = getPetDtoList().get(0);

        //when
        when(petConverter.toEntity(request)).thenReturn(pet);
        when(petRepository.existsPetByPublicId("test")).thenReturn(false);
        when(petRepository.save(pet)).thenReturn(pet);
        when(petConverter.convertToDto(pet)).thenReturn(petDto);

        PetDto response = petService.save(request);

        //then
        assertEquals(response,petDto);
        verify(petRepository).existsPetByPublicId("test");
        verify(petRepository).save(pet);
        verify(petConverter).convertToDto(pet);
        verify(petConverter).toEntity(request);
    }

    @Test
    public void getPetByPublicId_itShouldReturnPetDto(){
        //given
        Pet pet = getPetList().get(0);
        String publicId = "test";

        //when
        when(petRepository.findPetByPublicId(publicId)).thenReturn(Optional.ofNullable(pet));

        Pet response = petService.getPetByPublicId(publicId);

        //then
        assertEquals(response,pet);
        verify(petRepository).findPetByPublicId(publicId);
    }

    @Test
    public void delete(){
        //given
        Pet pet = getPetList().get(0);
        String publicId = "test";

        //when
        petRepository.delete(pet);

        petService.delete(publicId);

        //then
        verify(petRepository).delete(pet);
    }

}