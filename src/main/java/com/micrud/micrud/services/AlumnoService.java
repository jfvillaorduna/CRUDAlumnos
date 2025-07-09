package com.micrud.micrud.services;

import com.micrud.micrud.entities.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    Optional<Alumno> deleteById(Long id);
}
