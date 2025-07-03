package com.micrud.micrud.controllers;

import com.micrud.micrud.entities.Alumno;
import com.micrud.micrud.entities.Curso;
import com.micrud.micrud.services.AlumnoService;
import com.micrud.micrud.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    public AlumnoController(AlumnoService alumnoService, CursoService cursoService) {
        this.alumnoService = alumnoService;
        this.cursoService = cursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> details(@PathVariable Long id) {
        return alumnoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoService.findById(id);
        if (optionalAlumno.isPresent()) {
            Alumno alumnoDb = optionalAlumno.get();
            alumnoDb.setGrado(alumno.getGrado());
            alumnoDb.setName(alumno.getName());
            alumnoDb.setApellido(alumno.getApellido());
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> delete(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoService.deleteById(id);
        return optionalAlumno
                .map(alumno -> ResponseEntity.ok().body(alumno))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{alumnoId}/curso/{cursoId}")
    public ResponseEntity<Alumno> asignarCurso(
            @PathVariable Long alumnoId,
            @PathVariable Long cursoId
    ) {
        Optional<Alumno> alumnoOpt = alumnoService.findById(alumnoId);
        Optional<Curso> cursoOpt = cursoService.findById(cursoId);

        if (alumnoOpt.isPresent() && cursoOpt.isPresent()) {
            Alumno alumno = alumnoOpt.get();
            alumno.setCurso(cursoOpt.get());
            return ResponseEntity.ok(alumnoService.save(alumno));
        }

        return ResponseEntity.notFound().build();
    }

}
