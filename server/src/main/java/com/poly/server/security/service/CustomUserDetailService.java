package com.poly.server.security.service;

import com.poly.server.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    /**
     * Spring Security:
     * Authen: SELECT * FROM user WHERE username & password => User/TaiKhoan
     * Security => UserDetails (convert entity => UserDetails)
     * pass: Spring security => bcrypt...
     */

    @Autowired
    private PasswordEncoder passwordEncoder;

    // fake data
    private final List<TaiKhoan> listTaiKhoan = List.of(
            // fake lan luot cac tai khoan
            new TaiKhoan("user", "123456", "USER"),
            new TaiKhoan("admin", "1234567", "ADMIN")
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // B1: Lay ra doi tuong tai khoan
        // neu dung CSDL => repo
        TaiKhoan tk = listTaiKhoan.stream()
                .filter(s -> s.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Tai khoan k ton tai"));
        // B2: Chuyen doi tu tai khoan -> userdetails
        UserDetails userDetails = User.withUsername(tk.getUsername())
                .password(passwordEncoder.encode(tk.getPassword()))
                .roles(tk.getRole())
                .build();
        return userDetails;
    }
}
