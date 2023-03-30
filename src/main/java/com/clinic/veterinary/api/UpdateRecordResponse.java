package com.clinic.veterinary.api;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateRecordResponse {
    private Long id;
    private String recordContent;
}
