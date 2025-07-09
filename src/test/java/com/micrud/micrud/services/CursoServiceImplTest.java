package com.micrud.micrud.services;

import com.micrud.micrud.services.CursoServiceImpl;
import com.micrud.micrud.repositories.CursoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoServiceImplTest {

    @Test
    void instanciaCorrectaDelServicio() {
        CursoServiceImpl servicio = new CursoServiceImpl(null);
        assertNotNull(servicio);
    }
}