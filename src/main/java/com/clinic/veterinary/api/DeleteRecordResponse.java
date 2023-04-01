package com.clinic.veterinary.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteRecordResponse {

    private Long id;

    private String message;
    private boolean success;

    public DeleteRecordResponse(boolean success, Long id, String message) {
        this.success = success;
        this.id = id;
        this.message = message;
    }
}
