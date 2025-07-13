package com.micrud.micrud.services;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!username.equals("admin"))
            throw new UsernameNotFoundException("Usuario no encontrado");

        return new User(username, "$2a$10$ZpWg3UVcEXAMPLEPassHash", // contraseña: 1234
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
