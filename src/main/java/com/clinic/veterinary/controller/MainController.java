package com.clinic.veterinary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /**
     * 로그인 페이지
     */
    @GetMapping("/")
    public String main(){
        return "login";
    }
}
