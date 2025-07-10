package com.micrud.micrud.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceImplTest {

    @Test
    void instanciaSinErrores() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertNotNull(servicio);
    }

    @Test
    void guardarAlumnoConRepositorioNullRetornaNull() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertNull(servicio.save(null));
    }

    @Test
    void guardarAlumnoConRepositorioNullLanzaExcepcion() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertThrows(NullPointerException.class, () -> servicio.save(null));
    }

    @Test
    void buscarAlumnoSinRepositorioDebeLanzarExcepcion() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertThrows(NullPointerException.class, () -> servicio.findById(1L));
    }

    @Test
    void eliminarAlumnoConRepositorioNullNoHaceNada() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertThrows(NullPointerException.class, () -> servicio.deleteById(1L));
    }

    @Test
    void listarAlumnosConRepositorioNullRetornaNullOLanzaExcepcion() {
        AlumnoServiceImpl servicio = new AlumnoServiceImpl(null);
        assertThrows(NullPointerException.class, () -> servicio.findAll());
    }
}