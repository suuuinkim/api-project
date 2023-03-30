package com.clinic.veterinary.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordSearch {

    private String doctorName; // 의사 이름
    private String animalName; // 동물 이름
}
