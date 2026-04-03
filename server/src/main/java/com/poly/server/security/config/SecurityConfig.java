package com.poly.server.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // tao ra cac bean tuong ung

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager
            (AuthenticationConfiguration config) {
        return config.getAuthenticationManager();
    }

    // do...filter => J4
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        // code
        http
                // tat csft ( khi ma chay local moi tat)
                .csrf(c -> c.disable())
                // phan quyen
                .authorizeHttpRequests(s -> s
                        // Tat ca cac duong dan bang dau bang.. deu co the truy cap
                        .requestMatchers("/api/public/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/nhan-vien/**").hasRole("USER")
                )
                .httpBasic(Customizer.withDefaults()); // Su dung HTTP Basic de authen
        return http.build();
    }

}
