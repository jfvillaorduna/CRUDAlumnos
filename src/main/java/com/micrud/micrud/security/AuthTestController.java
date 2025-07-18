package com.micrud.micrud.security;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("cliente") // ✅ Solo activa cuando el perfil cliente está en uso
@RequestMapping("/api/auth-test") // ✅ Ruta única para evitar colisiones
public class AuthTestController {

    // Ruta pública, no requiere token
    @GetMapping("/public")
    public ResponseEntity<String> publicAccess() {
        return ResponseEntity.ok("✅ Ruta pública desde AuthTest: acceso sin token");
    }

    // Ruta protegida, requiere token válido sin importar rol
    @GetMapping("/protected")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> protectedAccess() {
        return ResponseEntity.ok("🔒 Ruta protegida: token JWT válido requerido");
    }

    // Ruta protegida con rol específico (ROLE_USER)
    @GetMapping("/user-role")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> roleProtectedAccess() {
        return ResponseEntity.ok("🛡️ Ruta protegida: acceso permitido con rol USER");
    }

    // Ruta protegida con rol específico (ROLE_ADMIN)
    @GetMapping("/admin-role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminAccess() {
        return ResponseEntity.ok("👑 Ruta protegida: acceso permitido con rol ADMIN");
    }
}