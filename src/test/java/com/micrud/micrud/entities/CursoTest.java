package com.micrud.micrud.entities;

import com.micrud.micrud.entities.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    @Test
    void crearCursoConNombre() {
        Curso curso = new Curso("Matemáticas");

        assertEquals("Matemáticas", curso.getNombre());
    }

    @Test
    void cambiarNombreCurso() {
        Curso curso = new Curso("Historia");
        curso.setNombre("Ciencias");

        assertEquals("Ciencias", curso.getNombre());
    }
}