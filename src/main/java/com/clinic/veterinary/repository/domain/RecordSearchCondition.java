package com.clinic.veterinary.repository.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RecordSearchCondition {

    private String doctorName; // 의사 이름
    private String animalName; // 동물 이름
}
