package com.example.appdevfram_ea;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoderWorks() {
        String rawPassword = "password";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        assertThat(passwordEncoder.matches(rawPassword, encodedPassword)).isTrue();
    }
}
