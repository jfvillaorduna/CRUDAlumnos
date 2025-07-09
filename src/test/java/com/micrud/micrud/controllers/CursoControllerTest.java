package com.micrud.micrud.controllers;

import com.micrud.micrud.controllers.CursoController;
import com.micrud.micrud.services.CursoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoControllerTest {

    @Test
    void constructorCursoController() {
        CursoController controller = new CursoController(null);
        assertNotNull(controller);
    }
}