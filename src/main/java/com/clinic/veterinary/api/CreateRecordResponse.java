package com.clinic.veterinary.api;

import lombok.Data;

@Data
public class CreateRecordResponse {
    private Long id;

    public CreateRecordResponse(Long id) {
        this.id = id;
    }
}
