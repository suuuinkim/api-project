package com.clinic.veterinary.service;

import com.clinic.veterinary.domain.Member;
import com.clinic.veterinary.domain.Role;
import com.clinic.veterinary.domain.dto.LoginDto;
import com.clinic.veterinary.domain.dto.UserDto;
import com.clinic.veterinary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Member join(UserDto userDto){

        Member user = new Member(userDto.getLoginId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), Role.USER, userDto.getDoctor());
        return userRepository.save(user);

    }

    @Transactional
    public String login(LoginDto loginDto){
        String loginId = loginDto.getLoginId();
        String password = loginDto.getPassword();

        System.out.println("password = " + password);

        Optional<Member> byLoginId = userRepository.findByLoginId(loginId);

        if(encoder.matches(password, byLoginId.get().getPassword())){
            return "로그인 성공";
        }

        return "로그인 실패";
    }
}
