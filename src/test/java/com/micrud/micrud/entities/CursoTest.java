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

    @Test
    void nombreNullDebeGuardarYRecuperarComoNull() {
        Curso curso = new Curso(null);
        assertNull(curso.getNombre());
    }

    @Test
    void crearCursoVacioYLuegoSetearNombre() {
        Curso curso = new Curso();
        curso.setNombre("Biología");

        assertEquals("Biología", curso.getNombre());
    }

    @Test
    void cursosIndependientesTienenNombresDistintos() {
        Curso c1 = new Curso("Arte");
        Curso c2 = new Curso("Química");

        assertNotEquals(c1.getNombre(), c2.getNombre());
    }
}