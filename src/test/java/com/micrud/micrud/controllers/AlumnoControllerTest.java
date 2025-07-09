package com.micrud.micrud.controllers;

import com.micrud.micrud.controllers.AlumnoController;
import com.micrud.micrud.services.AlumnoService;
import com.micrud.micrud.services.CursoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoControllerTest {

    @Test
    void construccionBasicaDelControlador() {
        AlumnoController controller = new AlumnoController(null, null);
        assertNotNull(controller);
    }
}