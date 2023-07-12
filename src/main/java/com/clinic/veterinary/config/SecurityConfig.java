package com.clinic.veterinary.config;

import com.clinic.veterinary.common.AuthFailureHandler;
import com.clinic.veterinary.common.AuthSuccessHandler;
import com.clinic.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
@RequiredArgsConstructor
@EnableWebSecurity // 시큐리티 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    /**
     * Spring Securiy에서 제공하는 비밀번호 암호화 객체
     */
    @Bean
    public BCryptPasswordEncoder encryptPassword(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encryptPassword());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable() // csrf 토큰 비활성화
                .authorizeRequests() // 요청 URL에 따라 접근 권한 설정
                .antMatchers("/", "/login", "/api/**", "/auth/**", "/posts/read/**", "/posts/search/**", "/index", "/main")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/") // 해당 주소로 로그인 페이지 호출
                .loginProcessingUrl("/login") // 해당 URL로 요청이 오면 스프링 시큐리티가 가로채서 로그인 처리
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 URL
                .logoutSuccessUrl("/main") // 성공리 return url
                .deleteCookies("JSESSIONID", "remember-me")
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/login?error=true&exception=Have been attempted to login from a new place. or session expired") // 세션이 만료된 경우 이동
                .and()
                .and().rememberMe() // 로그인 유지
                .alwaysRemember(false)
                .tokenValiditySeconds(43200)
                .rememberMeParameter("remember-me");

    }
//    @Autowired
//    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
//        this.customUserDetailsService = customUserDetailsService;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers( "/css/**", "/js/**", "/img/**", "/scss/**", "/vendor/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/login", "/api/**", "/auth/**", "/posts/read/**", "/posts/search/**", "/index", "/main")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/")
//                .defaultSuccessUrl("/main")
//                .and()
//            .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .and()
//            .csrf().disable();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
