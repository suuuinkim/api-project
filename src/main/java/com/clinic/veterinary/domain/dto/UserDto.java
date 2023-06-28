package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.Doctor;
import com.clinic.veterinary.domain.Member;
import com.clinic.veterinary.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String loginId;

    private String username;

    private String password;

    private String email;

    private Role role;

    private Doctor doctor;

    public Member toEntity(){
        Member user = Member.builder()
                .loginId(loginId)
                .username(username)
                .password(password)
                .email(email)
                .role(role.USER)
                .build();

        return user;
    }
}
