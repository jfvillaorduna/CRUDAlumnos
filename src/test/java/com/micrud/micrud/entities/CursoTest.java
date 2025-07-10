package com.micrud.micrud.entities;

import com.micrud.micrud.entities.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    //Constructor con parámetro funciona correctamente
    @Test
    void crearCursoConNombre() {
        Curso curso = new Curso("Matemáticas");

        assertEquals("Matemáticas", curso.getNombre());
    }

    //Setter actualiza correctamente el atributo nombre
    @Test
    void cambiarNombreCurso() {
        Curso curso = new Curso("Historia");
        curso.setNombre("Ciencias");

        assertEquals("Ciencias", curso.getNombre());
    }

    //Comportamiento seguro ante valores null
    @Test
    void nombreNullDebeGuardarYRecuperarComoNull() {
        Curso curso = new Curso(null);
        assertNull(curso.getNombre());
    }

    //Constructor vacío + setter funciona como esperado
    @Test
    void crearCursoVacioYLuegoSetearNombre() {
        Curso curso = new Curso();
        curso.setNombre("Biología");

        assertEquals("Biología", curso.getNombre());
    }

    //Independencia de instancia y estado entre objetos distintos
    @Test
    void cursosIndependientesTienenNombresDistintos() {
        Curso c1 = new Curso("Arte");
        Curso c2 = new Curso("Química");

        assertNotEquals(c1.getNombre(), c2.getNombre());
    }
}