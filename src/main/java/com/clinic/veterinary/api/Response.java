package com.clinic.veterinary.api;

import lombok.Data;

@Data
public class Response {
    // private Long id;
    private boolean success;
    private String message;
    public Response(Boolean success, String message) {
        this.success = success;
        // this.id = id;
        this.message = message;
    }
}
