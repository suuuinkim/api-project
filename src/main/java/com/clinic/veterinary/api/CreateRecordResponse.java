package com.clinic.veterinary.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateRecordResponse {
    private Long id;

    private boolean success;

    private String message;

    public CreateRecordResponse(Boolean success, Long id, String message) {
        this.success = success;
        this.id = id;
        this.message = message;
    }
}
