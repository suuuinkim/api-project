package com.clinic.veterinary.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class UserServiceTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoder() throws Exception{
        String password = "test1234";
        String encodedPassword = passwordEncoder.encode(password);

        boolean matches = passwordEncoder.matches(password, encodedPassword);
        assert(matches);
    }

}