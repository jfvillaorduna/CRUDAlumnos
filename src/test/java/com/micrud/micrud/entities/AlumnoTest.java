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
}