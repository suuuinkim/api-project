package com.clinic.veterinary.controller;

import com.clinic.veterinary.domain.dto.LoginDto;
import com.clinic.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    /**
     * 메인페이지 이동
     * @return index.html
     */
    @GetMapping("/main")
    public String main(HttpServletRequest request, Model model){
        // 세션에서 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        System.out.println("username = " + username);
        // 모델에 사용자 정보 추가
        model.addAttribute("username", username);

        return "index";
    }

    /**
     * 로그인 페이지 이동
     * @return login.html
     */
    @GetMapping("/")
    public String login(){
        return "login";
    }

    /**
     * 로그인 처리
     * @param loginDto
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto){
        String login = userService.login(loginDto);

        if("success".equals(login)){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/main")
                    .build();
        }else {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/")
                    .build();
        }
    }


    /**
     * 로그아웃 처리
     * @param request
     * @param response
     * @return
     * @throws ServletException
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

}
