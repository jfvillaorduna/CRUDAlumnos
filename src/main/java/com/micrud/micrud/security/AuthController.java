package com.micrud.micrud.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenProvider tokenProvider;

    public AuthController(AuthenticationManager authManager, JwtTokenProvider tokenProvider) {
        this.authManager = authManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );

            String token = tokenProvider.generateToken(authentication.getName());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (Exception e) {
            System.out.println("❌ Error en login: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // O 403 si querés
        }
    }
}