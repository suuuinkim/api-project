package com.clinic.veterinary.api.dto;

import com.clinic.veterinary.domain.RecordTreatmentArea;
import lombok.Data;

@Data
public class RecordTreatmentAreaDto {

    private Long recordTreatmentAreaId;

    private String treatmentAreaName;

    public RecordTreatmentAreaDto(RecordTreatmentArea recordTreatmentArea) {
        recordTreatmentAreaId = recordTreatmentArea.getId();
        treatmentAreaName = recordTreatmentArea.getTreatmentArea().getName();
    }
}
