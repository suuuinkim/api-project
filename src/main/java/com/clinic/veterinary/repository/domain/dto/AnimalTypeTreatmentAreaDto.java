package com.clinic.veterinary.repository.domain.dto;

import com.clinic.veterinary.repository.domain.AnimalTypeTreatmentArea;
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
