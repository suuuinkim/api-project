package com.clinic.veterinary.repository.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Animal {
    @Id
    @GeneratedValue
    @Column(name="animal_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "animalType_id")
    private AnimalType animalType;

    @JsonIgnore
    @OneToMany(mappedBy = "animal")
    private List<TreatmentRecord> treatmentRecords = new ArrayList<>();

    @Column(nullable = false, length = 10)
    private String name; // 동물이름

    // === 연관관계 메서드 === //
    public void addTreatmentRecord(TreatmentRecord treatmentRecord){
        treatmentRecords.add(treatmentRecord);
        treatmentRecord.setAnimal(this);
    }

    // === 생성 메서드 === //
    public static Animal createAnimal(AnimalType animalType, String name){
        Animal animal = new Animal();
        animal.setAnimalType(animalType);
        animal.setName(name);

        return animal;
    }
}
