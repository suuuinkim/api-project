package com.clinic.veterinary.service;

import com.clinic.veterinary.domain.CustomUserDetail;
import com.clinic.veterinary.domain.User;
import com.clinic.veterinary.domain.dto.UserSessionDto;
import com.clinic.veterinary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final HttpSession session;

    /**
     * db에서 loginId 확인
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByLoginId(username).orElseThrow(() ->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다 : " + username));

        session.setAttribute("user", new UserSessionDto(user));

        return new CustomUserDetail(user); // 시큐리티 세션에 유저 정보 저장
    }
}
