package com.micrud.micrud.controllers;

import com.micrud.micrud.entities.Alumno;
import com.micrud.micrud.entities.Curso;
import com.micrud.micrud.services.AlumnoService;
import com.micrud.micrud.services.CursoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("instancia1")
@SpringBootTest
class AlumnoControllerTest {

    @Test
    void construccionBasicaDelControlador() {
        AlumnoController controller = new AlumnoController(null, null);
        assertNotNull(controller);
    }

    @Test
    void eliminarAlumnoInexistenteDebeDar404() {
        AlumnoService alumnoService = new AlumnoService() {
            public Optional<Alumno> findById(Long id) { return Optional.empty(); }
            public Alumno save(Alumno alumno) { return null; }
            public Optional<Alumno> deleteById(Long id) { return Optional.empty(); }
            public List<Alumno> findAll() { return null; }
        };

        CursoService cursoService = new CursoService() {
            public List<Curso> findAll() { return null; }
            public Optional<Curso> findById(Long id) { return Optional.empty(); }
            public Curso save(Curso curso) { return null; }
            public void deleteById(Long id) {}
        };

        AlumnoController controller = new AlumnoController(alumnoService, cursoService);
        ResponseEntity<Alumno> respuesta = controller.delete(100L);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void asignarCursoFallaSiAlumnoNoExiste() {
        AlumnoService alumnoService = new AlumnoService() {
            public Optional<Alumno> findById(Long id) { return Optional.empty(); }
            public Alumno save(Alumno alumno) { return null; }
            public Optional<Alumno> deleteById(Long id) { return Optional.empty(); }
            public List<Alumno> findAll() { return null; }
        };

        Curso curso = new Curso("Lógica");
        curso.setId(20L);

        CursoService cursoService = new CursoService() {
            public List<Curso> findAll() { return null; }
            public Optional<Curso> findById(Long id) { return Optional.of(curso); }
            public Curso save(Curso curso) { return curso; }
            public void deleteById(Long id) {}
        };

        AlumnoController controller = new AlumnoController(alumnoService, cursoService);
        ResponseEntity<Alumno> respuesta = controller.asignarCurso(99L, 20L);

        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    void asignarCursoFallaSiCursoNoExiste() {
        Alumno alumno = new Alumno();
        alumno.setId(1L);

        AlumnoService alumnoService = new AlumnoService() {
            public Optional<Alumno> findById(Long id) { return Optional.of(alumno); }
            public Alumno save(Alumno a) { return a; }
            public Optional<Alumno> deleteById(Long id) { return Optional.empty(); }
            public List<Alumno> findAll() { return null; }
        };

        CursoService cursoService = new CursoService() {
            public List<Curso> findAll() { return null; }
            public Optional<Curso> findById(Long id) { return Optional.empty(); }
            public Curso save(Curso curso) { return null; }
            public void deleteById(Long id) {}
        };

        AlumnoController controller = new AlumnoController(alumnoService, cursoService);
        ResponseEntity<Alumno> respuesta = controller.asignarCurso(1L, 999L);

        assertEquals(404, respuesta.getStatusCodeValue());
    }
}