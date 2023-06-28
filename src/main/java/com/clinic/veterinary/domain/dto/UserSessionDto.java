package com.clinic.veterinary.domain.dto;

import com.clinic.veterinary.domain.Member;
import com.clinic.veterinary.domain.Role;
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

    public UserSessionDto(Member member){
        this.loginId = member.getLoginId();
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.role = member.getRole();
    }
}
