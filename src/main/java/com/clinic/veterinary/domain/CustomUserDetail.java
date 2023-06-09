package com.clinic.veterinary.domain;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class CustomUserDetail implements UserDetails {

    private final Member user;

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername(){
        return user.getUsername();
    }
    /**
     * 계정 만료 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    /**
     * 계정 잠금
     * true : 잠기지 않음
     * false : 잠금
     */
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    /**
     * 비밀번호 만료 여부
     * true : 만료 안됨
     * false : 만료
     */
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    /**
     * 사용자 활성화 여부
     * true : 만료 안됨
     * false : 만료
     */

    @Override
    public boolean isEnabled(){
        return true;
    }

    /**
     * 유저의 권한 목록
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> "ROLE_"+user.getRole());

        return collectors;
    }
}
