package com.clinic.veterinary.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException  {

    private boolean success;
    private String message;

}
