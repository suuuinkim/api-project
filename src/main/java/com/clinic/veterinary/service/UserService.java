package com.clinic.veterinary.service;

import com.clinic.veterinary.domain.Member;
import com.clinic.veterinary.domain.Role;
import com.clinic.veterinary.domain.dto.LoginDto;
import com.clinic.veterinary.domain.dto.UserDto;
import com.clinic.veterinary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Member join(UserDto userDto){

        Member user = new Member(userDto.getLoginId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), Role.USER, userDto.getDoctor());
        return userRepository.save(user);

    }

    @Transactional
    public String login(LoginDto loginDto){


//        String email = loginDto.getEmail();
        String loginId = loginDto.getLoginId();
        String password = loginDto.getPassword();

        System.out.println("loginId = " + loginId);
        System.out.println("password = " + password);

        Optional<Member> byLoginId = userRepository.findByLoginId(loginId);

        return "success";
//        if(encoder.matches(password, byLoginId.get().getPassword())){
//            return "success";
//        }
//        return "fail";
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Optional<Member> optionalMember = userRepository.findByLoginId(loginId);
        Member member = optionalMember.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getRole().name()));

        return new User(member.getLoginId(), member.getPassword(), authorities);
    }
}
