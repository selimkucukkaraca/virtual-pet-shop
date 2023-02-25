package com.pets.virtualpetshop;

import com.pets.virtualpetshop.dto.PetTypeDto;
import com.pets.virtualpetshop.model.PetType;

import java.util.List;

public class TestUtil {

    public List<PetTypeDto> getPetTypeDtoList(){
        return List.of(new PetTypeDto("test","test"));
    }

    public List<PetType> getPetTypeList(){
        return List.of(new PetType(1L,"test","test","test"));
    }
}
