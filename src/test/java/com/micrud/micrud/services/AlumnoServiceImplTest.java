package com.micrud.micrud.services;

import com.micrud.micrud.entities.Alumno;
import com.micrud.micrud.repositories.AlumnoRepository;
import com.micrud.micrud.services.AlumnoServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceImplTest {

    @Test
    void instanciaSinErrores() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertNotNull(servicio);
    }
}