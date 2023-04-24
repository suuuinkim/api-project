package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.Role;
import com.clinic.veterinary.domain.User;
import lombok.Getter;

/**
 * 인증된 사용자 정보를 세션에 저장하는 UserSessionDto
 */
@Getter
public class UserSessionDto {
    private String loginId;
    private String username;
    private String password;
    private String email;
    private Role role;

    public UserSessionDto(User user){
        this.loginId = user.getLoginId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
