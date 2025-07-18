package com.micrud.micrud.entities;

import com.micrud.micrud.entities.Alumno;
import com.micrud.micrud.entities.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("instancia1")
@SpringBootTest
class AlumnoTest {

    //Setters y Getters básicos funcionando correctamente
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

    //Relación entre Alumno y Curso
    @Test
    void asignarCursoAAlumno() {
        Curso curso = new Curso("Programación");
        Alumno alumno = new Alumno();
        alumno.setCurso(curso);

        assertEquals("Programación", alumno.getCurso().getNombre());
    }

    //Estado por defecto cuando no se setea nombre
    @Test
    void alumnoSinNombreDebeTenerNombreNull() {
        Alumno alumno = new Alumno();
        assertNull(alumno.getName());
    }

    //Capacidad de actualizar atributos
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

    //Evita errores al acceder a curso no definido
    @Test
    void alumnoSinCursoDebeTenerCursoNull() {
        Alumno alumno = new Alumno();
        assertNull(alumno.getCurso());
    }

    //Identidad de objetos basada en instancia, no en datos
    @Test
    void dosAlumnosConMismoNombreNoSonElMismoObjeto() {
        Alumno a1 = new Alumno();
        a1.setName("Lucía");

        Alumno a2 = new Alumno();
        a2.setName("Lucía");

        assertNotSame(a1, a2);
    }

}