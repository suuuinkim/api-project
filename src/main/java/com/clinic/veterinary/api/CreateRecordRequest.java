package com.clinic.veterinary.api;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CreateRecordRequest {

    private Long doctorId;

    private List<Long> treatmentAreaIds;

    private Long animalId;

    private Long animalTypeId;

    @NotEmpty
    private String recordContent;

}
