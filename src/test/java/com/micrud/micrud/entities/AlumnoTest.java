package com.micrud.micrud.entities;

import com.micrud.micrud.entities.Alumno;
import com.micrud.micrud.entities.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    void crearAlumnoConDatos() {
        Alumno alumno = new Alumno();
        alumno.setName("Luis");
        alumno.setApellido("Gómez");
        alumno.setGrado("5to");

        assertEquals("Luis", alumno.getName());
        assertEquals("Gómez", alumno.getApellido());
        assertEquals("5to", alumno.getGrado());
    }

    @Test
    void asignarCursoAAlumno() {
        Curso curso = new Curso("Programación");
        Alumno alumno = new Alumno();
        alumno.setCurso(curso);

        assertEquals("Programación", alumno.getCurso().getNombre());
    }

    @Test
    void alumnoSinNombreDebeTenerNombreNull() {
        Alumno alumno = new Alumno();
        assertNull(alumno.getName());
    }

    @Test
    void cambiarNombreYGradoLuegoDeCreado() {
        Alumno alumno = new Alumno();
        alumno.setName("Luis");
        alumno.setGrado("4to");

        alumno.setName("Carlos");
        alumno.setGrado("6to");

        assertEquals("Carlos", alumno.getName());
        assertEquals("6to", alumno.getGrado());
    }

    @Test
    void alumnoSinCursoDebeTenerCursoNull() {
        Alumno alumno = new Alumno();
        assertNull(alumno.getCurso());
    }

    @Test
    void dosAlumnosConMismoNombreNoSonElMismoObjeto() {
        Alumno a1 = new Alumno();
        a1.setName("Lucía");

        Alumno a2 = new Alumno();
        a2.setName("Lucía");

        assertNotSame(a1, a2);
    }

}