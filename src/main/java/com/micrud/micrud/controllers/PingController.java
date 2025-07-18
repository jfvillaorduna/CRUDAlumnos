package com.micrud.micrud.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile({"instancia1", "instancia2"})
public class PingController {

    @Value("${spring.profiles.active:desconocido}")
    private String perfil;

    @GetMapping("/api/test/public")
    public ResponseEntity<String> publico() {
        String mensaje;

        switch (perfil) {
            case "instancia1" -> mensaje = "Hola desde instancia 1 ✅";
            case "instancia2" -> mensaje = "Hola desde instancia 2 🟢";
            default -> mensaje = "Hola desde instancia desconocida 😶";
        }

        return ResponseEntity.ok(mensaje);
    }
}
