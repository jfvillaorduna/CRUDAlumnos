package com.micrud.micrud.services;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //busca el usuario cuando hace login
    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!username.equals("admin"))
            throw new UsernameNotFoundException("Usuario no encontrado");
//crea un obj que representa al usuario y sus permisos
        return new User(username,
                "$2a$10$ptExzqRzpX6lxUf2DhyL3ONPpriT1oo0g5/XRq4iSQ73hxrwjPm/m", // contraseña: 1234
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
