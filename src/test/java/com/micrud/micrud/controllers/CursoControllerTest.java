package com.micrud.micrud.controllers;

import com.micrud.micrud.controllers.CursoController;
import com.micrud.micrud.entities.Curso;
import com.micrud.micrud.services.CursoService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CursoControllerTest {

    @Test
    void constructorCursoController() {
        CursoController controller = new CursoController(null);
        assertNotNull(controller);
    }

    @Test
    void buscarCursoInexistenteDebeRetornar404() {
        CursoService service = new CursoService() {
            public List<Curso> findAll() { return null; }
            public Optional<Curso> findById(Long id) { return Optional.empty(); }
            public Curso save(Curso curso) { return null; }
            public void deleteById(Long id) {}
        };

        CursoController controller = new CursoController(service);
        ResponseEntity<Curso> respuesta = controller.buscarPorId(500L);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void eliminarCursoInexistenteDebeRetornar404() {
        CursoService service = new CursoService() {
            public List<Curso> findAll() { return null; }
            public Optional<Curso> findById(Long id) { return Optional.empty(); }
            public Curso save(Curso curso) { return null; }
            public void deleteById(Long id) {}
        };

        CursoController controller = new CursoController(service);
        ResponseEntity<Void> respuesta = controller.eliminar(123L);

        assertEquals(404, respuesta.getStatusCodeValue());
    }
}