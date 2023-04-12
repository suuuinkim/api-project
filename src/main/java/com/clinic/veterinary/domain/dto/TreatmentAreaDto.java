package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.TreatmentArea;
import lombok.Data;

@Data
public class TreatmentAreaDto {
    private Long treatmentAreaId;
    private String treatmentAreaName;

    public TreatmentAreaDto(TreatmentArea treatmentArea) {
        treatmentAreaId = treatmentArea.getId();
        treatmentAreaName = treatmentArea.getName();
    }
}
