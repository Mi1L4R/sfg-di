package com.springframework.pets;

import org.springframework.context.annotation.Profile;

/**
 * Created by jt on 12/28/19.
 */
public class DogPetService implements PetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}