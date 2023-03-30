package com.clinic.veterinary.api.dto;

import com.clinic.veterinary.domain.AnimalTypeTreatmentArea;
import lombok.Data;

@Data
public class AnimalTypeTreatmentAreaDto {

    private Long animalTypeTreatmentAreaId;
    private String animalTypeTreatmentAreaName;


    public AnimalTypeTreatmentAreaDto(AnimalTypeTreatmentArea animalTypeTreatmentArea) {
        animalTypeTreatmentAreaId = animalTypeTreatmentArea.getId();
        animalTypeTreatmentAreaName = animalTypeTreatmentArea.getName();

    }
}
