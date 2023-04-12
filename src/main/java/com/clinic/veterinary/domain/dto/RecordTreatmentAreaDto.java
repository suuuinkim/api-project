package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.RecordTreatmentArea;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class RecordTreatmentAreaDto {
    private Long recordTreatmentAreaId;

    private String treatmentAreaName;

    public RecordTreatmentAreaDto(RecordTreatmentArea recordTreatmentArea) {
        this.recordTreatmentAreaId = recordTreatmentArea.getId();
        this.treatmentAreaName = recordTreatmentArea.getTreatmentArea().getName();
    }

    @QueryProjection
    public RecordTreatmentAreaDto(Long recordTreatmentAreaId, String treatmentAreaName) {
        this.recordTreatmentAreaId = recordTreatmentAreaId;
        this.treatmentAreaName = treatmentAreaName;
    }
}
