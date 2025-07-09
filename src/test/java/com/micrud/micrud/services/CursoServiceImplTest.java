package com.micrud.micrud.services;

import com.micrud.micrud.entities.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoServiceImplTest {

    @Test
    void instanciaCorrectaDelServicio() {
        CursoServiceImpl servicio = new CursoServiceImpl(null);
        assertNotNull(servicio);
    }

    @Test
    void guardarCursoConRepositorioNullLanzaExcepcion() {
        CursoServiceImpl servicio = new CursoServiceImpl(null);
        Curso curso = new Curso("Redes");
        assertThrows(NullPointerException.class, () -> servicio.save(curso));
    }

    @Test
    void buscarCursoConRepositorioNullLanzaExcepcion() {
        CursoServiceImpl servicio = new CursoServiceImpl(null);
        assertThrows(NullPointerException.class, () -> servicio.findById(1L));
    }

    @Test
    void listarCursosConRepositorioNullLanzaExcepcion() {
        CursoServiceImpl servicio = new CursoServiceImpl(null);
        assertThrows(NullPointerException.class, () -> servicio.findAll());
    }

    @Test
    void eliminarCursoConRepositorioNullNoLanzaError() {
        CursoServiceImpl servicio = new CursoServiceImpl(null);
        assertDoesNotThrow(() -> servicio.deleteById(10L));
    }
}