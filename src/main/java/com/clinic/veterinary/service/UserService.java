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
//        String loginId = loginDto.getLoginId();
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();

        System.out.println("password = " + password);

        Optional<Member> byLoginId = userRepository.findByEmail(email);

        if(encoder.matches(password, byLoginId.get().getPassword())){
            return "success";
        }

        return "fail";
    }
}
