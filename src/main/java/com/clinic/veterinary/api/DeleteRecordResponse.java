package com.clinic.veterinary.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteRecordResponse {
    private String message;
    private boolean success;
    public DeleteRecordResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

//
}
