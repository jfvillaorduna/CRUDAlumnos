package com.micrud.micrud.services;

import com.micrud.micrud.entities.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> findAll();

    Optional<Curso> findById(Long id);

    Curso save(Curso curso);

    void deleteById(Long id);
}

