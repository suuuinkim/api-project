package com.clinic.veterinary.domain.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String loginId;
//    private String email;
    private String password;
}
