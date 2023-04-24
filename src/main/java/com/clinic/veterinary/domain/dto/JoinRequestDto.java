package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.Doctor;
import com.clinic.veterinary.domain.Role;
import com.clinic.veterinary.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class JoinRequestDto {

    private String loginId;

    private String username;

    private String password;

    private String email;

    private Role role;

}
