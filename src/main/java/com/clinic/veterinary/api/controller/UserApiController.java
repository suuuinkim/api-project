package com.clinic.veterinary.api.controller;

import com.clinic.veterinary.api.Response;
import com.clinic.veterinary.domain.Member;
import com.clinic.veterinary.domain.dto.LoginDto;
import com.clinic.veterinary.domain.dto.UserDto;
import com.clinic.veterinary.repository.UserRepository;
import com.clinic.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;
    
    @PostMapping("/api/v1/join")
    public Response join(@RequestBody @Valid UserDto userDto){

        Member member = userService.join(userDto);
        return new Response(true, "회원가입이 완료되었습니다.");
    }


    @PostMapping("/api/v1/login")
    public Response login(@RequestBody @Valid LoginDto loginDto){
        String login = userService.login(loginDto);
        return new Response(true, login);
    }
}
