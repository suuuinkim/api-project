package com.clinic.veterinary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Doctor {

    @Id @GeneratedValue
    @Column(name = "doctor_id")
    private Long id;

    @Column(nullable = false, length = 10)
    private String name; // 의사이름
    
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<TreatmentRecord> treatmentRecords = new ArrayList<>();

    @OneToOne
    private User user;
}
