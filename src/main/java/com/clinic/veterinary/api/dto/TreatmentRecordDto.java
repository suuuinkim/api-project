package com.clinic.veterinary.api.dto;

import com.clinic.veterinary.domain.TreatmentRecord;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TreatmentRecordDto {
    private Long treatmentRecordId; // 진료 기록 고유번호
    private String doctorName; // 의사 이름
    private String animalName; // 동물 이름
    private String animalType; // 동물 타입

    private List<RecordTreatmentAreaDto> recordTreatmentAreas; // 중간테이블

    private LocalDateTime recordDate; // 진료 날짜
    private String recordContent; // 진료 내용

    private List<AnimalTypeTreatmentAreaDto> animalTypeTreatmentAreas;


    public TreatmentRecordDto(TreatmentRecord treatmentRecord) {

        treatmentRecordId = treatmentRecord.getId();
        doctorName = treatmentRecord.getDoctor().getName();
        animalName = treatmentRecord.getAnimal().getName();
        animalType = treatmentRecord.getAnimalType().getName();

        recordTreatmentAreas = treatmentRecord.getRecordTreatmentAreas().stream()
                .map(recordTreatmentArea -> new RecordTreatmentAreaDto(recordTreatmentArea))
                .collect(Collectors.toList());

        recordDate = treatmentRecord.getRecordDate();
        recordContent = treatmentRecord.getRecordContent();

        animalTypeTreatmentAreas = treatmentRecord.getAnimalType().getAnimalTypeTreatmentAreas().stream()
                .filter(ta -> ta.getAnimalType().getId().equals(treatmentRecord.getAnimalType().getId()))
                .map(ta -> new AnimalTypeTreatmentAreaDto(ta))
                .collect(Collectors.toList());


    }


}
