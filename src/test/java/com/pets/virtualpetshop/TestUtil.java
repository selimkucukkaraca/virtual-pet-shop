package com.pets.virtualpetshop;

import com.pets.virtualpetshop.dto.PetDto;
import com.pets.virtualpetshop.dto.PetFoodDto;
import com.pets.virtualpetshop.dto.PetFoodTypeDto;
import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.dto.request.CreatePetFoodRequest;
import com.pets.virtualpetshop.dto.request.CreatePetFoodTypeRequest;
import com.pets.virtualpetshop.dto.request.CreatePetRequest;
import com.pets.virtualpetshop.model.Pet;
import com.pets.virtualpetshop.model.PetFood;
import com.pets.virtualpetshop.model.PetFoodType;
import com.pets.virtualpetshop.model.PetType;

import java.util.List;

public class TestUtil {

    public List<PetTypeDto> getPetTypeDtoList(){
        return List.of(new PetTypeDto("test","test"));
    }

    public List<PetType> getPetTypeList(){
        return List.of(new PetType(1L,"test","test","test"));
    }

    public CreatePetRequest getCreatePetRequest(){
        return new CreatePetRequest("test","test",1,"test");
    }

    public List<PetDto> getPetDtoList(){
        return List.of(new PetDto(null,1,"test","test"));
    }

    public List<Pet> getPetList(){
        return List.of(new Pet(1L,null,1,"test","test"));
    }

    public CreatePetFoodTypeRequest getCreatePetFoodTypeRequest(){
        return new CreatePetFoodTypeRequest("test","test");
    }
    public List<PetFoodTypeDto> getPetFoodTypeDtoList(){
        return List.of(new PetFoodTypeDto("test","test"));
    }
    public List<PetFoodType> getPetFoodTypeList(){
        return List.of(new PetFoodType(1L,"test","test"));
    }
    public CreatePetFoodRequest getCreatePetFoodRequest(){
        return new CreatePetFoodRequest("test","test",1);
    }
    public List<PetFoodDto> getPetFoodDtoList(){
        return List.of(new PetFoodDto(null,1,"test"));
    }
    public List<PetFood> getPetFoodList(){
        return List.of(new PetFood(1L,null,1,"test"));
    }
}