package com.clinic.veterinary.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class TreatmentRecord {

    @Id @GeneratedValue
    @Column(name = "treatmentRecord_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;


    @OneToMany(mappedBy = "treatmentRecord", cascade = CascadeType.ALL)
    private List<RecordTreatmentArea> recordTreatmentAreas = new ArrayList<>();

    private LocalDateTime recordDate; // 진료일자

    private String recordContent; // 진료내용


    // ==== 생성 메서드 ==== //
    public void addRecordTreatmentArea(RecordTreatmentArea recordTreatmentArea){
        if (recordTreatmentArea != null) {
            this.recordTreatmentAreas.add(recordTreatmentArea);
            recordTreatmentArea.setTreatmentRecord(this);
        }
    }

    public static TreatmentRecord createTreatmentRecord(Doctor doctor, Animal animal, AnimalType animalType, String recordContent, RecordTreatmentArea... recordTreatmentAreas){
        TreatmentRecord treatmentRecord = new TreatmentRecord();

        treatmentRecord.setDoctor(doctor);
        treatmentRecord.setAnimal(animal);
        treatmentRecord.setRecordDate(LocalDateTime.now());
        treatmentRecord.setRecordContent(recordContent);

        for(RecordTreatmentArea recordTreatmentArea : recordTreatmentAreas){
            treatmentRecord.addRecordTreatmentArea(recordTreatmentArea);
        }

        return treatmentRecord;
    }

}
