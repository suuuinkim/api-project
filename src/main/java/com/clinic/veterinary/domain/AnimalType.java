package com.clinic.veterinary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class AnimalType {

    @Id @GeneratedValue
    @Column(name = "animalType_id")
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "animalType")
    private List<Animal> animals = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "animalType")
    private List<AnimalTypeTreatmentArea> animalTypeTreatmentAreas = new ArrayList<>();

}
