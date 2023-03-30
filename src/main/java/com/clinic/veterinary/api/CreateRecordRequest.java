package com.clinic.veterinary.api;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateRecordRequest {

    private Long doctorId;

    private Long treatmentAreaId;

    private Long animalId;

    private Long animalTypeId;

    @NotEmpty
    private String recordContent;

    // private Long recordTreatmentAreaId;
}
