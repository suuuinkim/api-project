package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.Role;
import lombok.Data;

@Data
public class JoinRequestDto {

    private String loginId;

    private String username;

    private String password;

    private String email;

    private Role role;

}
