package com.clinic.veterinary.controller;

import com.clinic.veterinary.domain.dto.LoginDto;
import com.clinic.veterinary.repository.UserRepository;
import com.clinic.veterinary.service.CustomUserDetailsService;
import com.clinic.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;

    /**
     * 메인페이지 이동
     * @return index.html
     */
//    @GetMapping("/main")
//    public String main(@SessionAttribute(name = "loginId", required = false) Long loginId){
//
//        System.out.println("loginId = " + loginId);
//        return "index";
//    }

//    @GetMapping("/main")
//    public String main(HttpServletRequest request){
//        HttpSession session = request.getSession(true);
//        System.out.println("session = " + session.getId());
//
//        if(session != null){
//            SecurityContext securityContext = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
//            System.out.println("securityContext = " + securityContext);
//            if(securityContext != null){
//                Authentication authentication = securityContext.getAuthentication();
//                System.out.println("authentication = " + authentication);
//                if(authentication != null){
//                    String name = authentication.getName();
//                    System.out.println("Logged in user name: " + name);
//                }
//            }
//        }
//
//        return "index";
//    }

    @GetMapping("/main")
    public String main(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session != null){
            SecurityContext securityContext = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
            if(securityContext != null){
                Authentication authentication = securityContext.getAuthentication();
                if(authentication != null){
                    String name = authentication.getName();
                    System.out.println("Logged in user name: " + name);
                }
            }
        }

        return "index";
    }


    /**
     * 로그인 페이지 이동
     * @return login.html
     */
    @GetMapping("/")
    public String login(){
        return "/member/login";
    }

    /**
     * 로그인 처리
     * @param loginDto
     * @return
     */
//    @PostMapping(value = "/login")
//    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto, HttpServletRequest request, HttpSession session){
//        System.out.println(">>> 지금 여기 타나 ?????? ");
//
//        String login = userService.login(loginDto);
//
//        if("success".equals(login)){
////            // 로그인 성공 시 세션에 사용자 정보 저장
////            Member member = userRepository.findByLoginId(loginDto.getLoginId())
////                    .orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다: " + loginDto.getLoginId()));
////            session.setAttribute("user", new UserSessionDto(member));
//
//            // 로그인 성공 시 사용자 정보로 인증 객체 생성
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.getLoginId());
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//            // SecurityContextHolder를 통해 인증 객체 설정
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // 세션에 인증 객체 저장
//            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
//
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .header("Location", "/main")
//                    .build();
//        }else {
//            return ResponseEntity.status(HttpStatus.FOUND)
//                    .header("Location", "/")
//                    .build();
//        }
//    }



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
