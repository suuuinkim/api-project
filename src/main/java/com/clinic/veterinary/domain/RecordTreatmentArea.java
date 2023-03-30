package com.clinic.veterinary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecordTreatmentArea {

    @Id @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "treatmentRecord_id")
    private TreatmentRecord treatmentRecord;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "treatmentArea_id")
    private TreatmentArea treatmentArea;

    public RecordTreatmentArea(TreatmentRecord treatmentRecord, TreatmentArea treatmentArea) {
    }

    public RecordTreatmentArea() {

    }


    public static RecordTreatmentArea createRecordTreatmentArea(TreatmentRecord treatmentRecord, TreatmentArea treatmentArea) {
        RecordTreatmentArea recordTreatmentArea = new RecordTreatmentArea();
        recordTreatmentArea.setTreatmentRecord(treatmentRecord);
        recordTreatmentArea.setTreatmentArea(treatmentArea);

        return recordTreatmentArea;

    }
}
