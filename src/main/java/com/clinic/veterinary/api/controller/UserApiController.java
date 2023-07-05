package com.clinic.veterinary.api.controller;

import com.clinic.veterinary.api.Response;
import com.clinic.veterinary.domain.Member;
import com.clinic.veterinary.domain.dto.LoginDto;
import com.clinic.veterinary.domain.dto.UserDto;
import com.clinic.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    
    @PostMapping("/api/v1/join")
    public Response join(@RequestBody @Valid UserDto userDto){

        Member member = userService.join(userDto);
        return new Response(true, "회원가입이 완료되었습니다.");
    }

//    @RequestMapping(value = "/login")
//    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto){
//        String login = userService.login(loginDto);
//
//        if("success".equals(login)){
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .header("Location", "/main")
//                    .build();
//        }else {
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .header("Location", "/")
//                    .build();
//        }
//    }
}
