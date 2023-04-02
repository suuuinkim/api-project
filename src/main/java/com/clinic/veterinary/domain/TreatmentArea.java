package com.clinic.veterinary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TreatmentArea {

    @Id @GeneratedValue
    @Column(name = "treatmentArea_id")
    private Long id;


    @OneToMany(mappedBy = "treatmentArea", cascade = CascadeType.ALL)
    private List<RecordTreatmentArea> recordTreatmentAreas = new ArrayList<>();

    @Column(name = "treatmentName")
    private String name;

    public static TreatmentArea createTreatmentArea(String name) {
        TreatmentArea treatmentArea = new TreatmentArea();
        treatmentArea.setName(name);
        return treatmentArea;
    }
}
