package com.clinic.veterinary.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteRecordResponse {
    private Long id;
    private boolean success;
}
