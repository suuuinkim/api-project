package com.clinic.veterinary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class AnimalTypeTreatmentArea {

    @Id @GeneratedValue
    @Column(name = "animalTypeTreatmentArea_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "animalType_id")
    private AnimalType animalType;

    @Column(nullable = false, length = 20)
    private String name;

    // === 생성메소드 === //
    public static AnimalTypeTreatmentArea createAnimalTypeTreatmentArea(AnimalType animalType, String name){
        AnimalTypeTreatmentArea animalTypeTreatmentArea = new AnimalTypeTreatmentArea();
        animalTypeTreatmentArea.setAnimalType(animalType);
        animalTypeTreatmentArea.setName(name);

        return animalTypeTreatmentArea;
    }
}
