package com.micrud.micrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Profile("cliente")
@RequestMapping("/")
public class BalanceoController {

    @Autowired
    private RestTemplate restTemplate;

    private final List<String> instances = List.of(
            "http://localhost:8080/api/test/public",
            "http://localhost:8081/api/test/public"
    );

    private int counter = 0;

    @GetMapping("/balanceado")
    public ResponseEntity<String> testBalanceo(@RequestHeader(value = "Authorization", required = false) String bearerToken) {
        String url = instances.get(counter % instances.size());
        counter++;

        HttpHeaders headers = new HttpHeaders();
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            headers.set("Authorization", bearerToken);
        }

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            String json = String.format("""
                {
                  "instancia": "%s",
                  "url": "%s",
                  "respuesta": "%s",
                  "timestamp": "%s"
                }
                """,
                    url.contains("8080") ? "instancia1" : "instancia2",
                    url,
                    response.getBody(),
                    LocalDateTime.now()
            );

            return ResponseEntity.ok(json);

        } catch (Exception ex) {
            String error = String.format("""
                {
                  "error": "No se pudo contactar con %s",
                  "detalles": "%s",
                  "timestamp": "%s"
                }
                """, url, ex.getMessage(), LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
        }
    }
}